/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.influxdb.client.internal;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.WriteApi;
import com.influxdb.client.WriteOptions;
import com.influxdb.client.domain.WriteConsistency;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.internal.flowable.BackpressureBatchesBufferStrategy;
import com.influxdb.client.internal.flowable.FlowableBufferTimedFlushable;
import com.influxdb.client.service.WriteService;
import com.influxdb.client.write.Point;
import com.influxdb.client.write.WriteParameters;
import com.influxdb.client.write.events.AbstractWriteEvent;
import com.influxdb.client.write.events.BackpressureEvent;
import com.influxdb.client.write.events.WriteErrorEvent;
import com.influxdb.client.write.events.WriteRetriableErrorEvent;
import com.influxdb.client.write.events.WriteSuccessEvent;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.processors.PublishProcessor;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.reactivestreams.Publisher;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * @author Jakub Bednar (bednar@github) (21/11/2018 09:26)
 */
public abstract class AbstractWriteClient extends AbstractRestClient implements AutoCloseable {

    private static final Logger LOG = Logger.getLogger(AbstractWriteClient.class.getName());

    private static final String CLOSED_EXCEPTION = "WriteApi is closed. " + "Data should be written before calling InfluxDBClient.close or WriteApi.close.";

    private static final int DEFAULT_WAIT = 30_000;

    private static final int DEFAULT_SLEEP = 25;

    private final WriteOptions writeOptions;

    protected final InfluxDBClientOptions options;

    private final PublishProcessor<BatchWriteItem> processor;

    private final PublishProcessor<Boolean> flushPublisher;

    private final PublishSubject<AbstractWriteEvent> eventPublisher;

    protected final MeasurementMapper measurementMapper = new MeasurementMapper();

    private final WriteService service;

    private final Collection<AutoCloseable> autoCloseables;

    private AtomicBoolean finished = new AtomicBoolean(false);

    public AbstractWriteClient(@Nonnull final WriteOptions writeOptions, @Nonnull final InfluxDBClientOptions options, @Nonnull final Scheduler processorScheduler, @Nonnull final WriteService service, @Nonnull final Collection<AutoCloseable> autoCloseables) {
        Arguments.checkNotNull(options, "options");
        this.writeOptions = writeOptions;
        this.options = options;
        this.service = service;
        this.autoCloseables = autoCloseables;
        this.flushPublisher = PublishProcessor.create();
        this.eventPublisher = PublishSubject.create();
        this.processor = PublishProcessor.create();
        processor.//
        // Enable Backpressure
        //
        onBackpressureBuffer(writeOptions.getBufferLimit(), () -> publish(new BackpressureEvent(BackpressureEvent.BackpressureReason.FAST_EMITTING)), writeOptions.getBackpressureStrategy()).//
        // Group by Bucket, Org, Precision, Consistency
        //
        groupBy(it -> it.writeParameters).flatMap(group -> group.//
        // Use Buffer to create Batch Items
        //
        compose(source -> new FlowableBufferTimedFlushable<>(source, flushPublisher, writeOptions.getFlushInterval(), TimeUnit.MILLISECONDS, writeOptions.getBatchSize(), processorScheduler, ArrayListSupplier.asSupplier())).//
        // Collect Batch items into one Write Item
        //
        map(batchItems -> {
            BatchWriteDataGrouped batch = new BatchWriteDataGrouped(group.getKey());
            for (BatchWriteItem item : batchItems) {
                try {
                    batch.append(item.data.toLineProtocol());
                } catch (Exception e) {
                    publish(new WriteErrorEvent(e));
                }
            }
            return new BatchWriteItem(batch.group, batch);
        })).filter(batch -> batch.length() > 0).//
        // Add backpressure to GroupBy. For more info see:
        //      https://github.com/ReactiveX/RxJava/wiki/What's-different-in-3.0#backpressure-in-groupby
        //
        flatMap(Flowable::just, Integer.MAX_VALUE).//
        // Add backpressure strategy to cover outage of the server
        //
        lift(new BackpressureBatchesBufferStrategy(writeOptions.getBufferLimit(), droppedPoints -> publish(new BackpressureEvent(BackpressureEvent.BackpressureReason.TOO_MUCH_BATCHES, droppedPoints)), writeOptions.getBackpressureStrategy(), writeOptions.getCaptureBackpressureData())).//
        // Use concat to process batches with configurable prefetch
        //
        concatMapMaybe(new ToWritePointsMaybe(processorScheduler, writeOptions), writeOptions.getConcatMapPrefetch()).doFinally(() -> finished.set(true)).subscribe(responseNotification -> {
            if (responseNotification.isOnError()) {
                publish(new WriteErrorEvent(toInfluxException(responseNotification.getError())));
            }
        }, throwable -> publish(new WriteErrorEvent(toInfluxException(throwable))));
        autoCloseables.add(this);
    }

    @Nonnull
    protected <T extends AbstractWriteEvent> Observable<T> addEventListener(@Nonnull final Class<T> eventType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void flush() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void writePoints(@Nonnull final WriteParameters writeParameters, @Nonnull final Flowable<BatchWriteDataPoint> stream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void write(@Nonnull final WriteParameters writeParameters, @Nonnull final Publisher<AbstractWriteClient.BatchWriteData> stream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void write(@Nonnull final Flowable<BatchWriteItem> stream) {
        if (processor.hasComplete()) {
            throw new InfluxException(CLOSED_EXCEPTION);
        }
        stream.subscribe(processor::onNext, throwable -> publish(new WriteErrorEvent(throwable)));
    }

    private <T extends AbstractWriteEvent> void publish(@Nonnull final T event) {
        Arguments.checkNotNull(event, "event");
        event.logEvent();
        eventPublisher.onNext(event);
    }

    public interface BatchWriteData {

        @Nullable
        String toLineProtocol();

        @Nonnull
        Long length();
    }

    public static final class BatchWriteDataRecord implements BatchWriteData {

        private final String record;

        public BatchWriteDataRecord(@Nullable final String record) {
            this.record = record;
        }

        @Nullable
        @Override
        public String toLineProtocol() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nonnull
        @Override
        public Long length() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class BatchWriteDataGrouped implements BatchWriteData {

        private final WriteParameters group;

        private final StringBuilder sb = new StringBuilder();

        private Long length = 0L;

        public BatchWriteDataGrouped(@Nonnull final WriteParameters group) {
            this.group = group;
        }

        @Override
        public String toLineProtocol() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nonnull
        @Override
        public Long length() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void append(@Nullable final String lineProtocol) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class BatchWriteDataPoint implements BatchWriteData {

        private static final Logger LOG = Logger.getLogger(BatchWriteDataPoint.class.getName());

        private final Point point;

        private final WritePrecision precision;

        private final InfluxDBClientOptions options;

        public BatchWriteDataPoint(@Nonnull final Point point, @Nonnull final InfluxDBClientOptions options) {
            this(point, point.getPrecision(), options);
        }

        public BatchWriteDataPoint(@Nonnull final Point point, @Nonnull final WritePrecision precision, @Nonnull final InfluxDBClientOptions options) {
            this.point = point;
            this.precision = precision;
            this.options = options;
        }

        @Nullable
        @Override
        public String toLineProtocol() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nonnull
        @Override
        public Long length() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class BatchWriteDataMeasurement implements BatchWriteData {

        private final Object measurement;

        private final WritePrecision precision;

        private final InfluxDBClientOptions options;

        private final MeasurementMapper measurementMapper;

        public BatchWriteDataMeasurement(@Nullable final Object measurement, @Nonnull final WritePrecision precision, @Nonnull final InfluxDBClientOptions options, @Nonnull final MeasurementMapper measurementMapper) {
            this.measurement = measurement;
            this.precision = precision;
            this.options = options;
            this.measurementMapper = measurementMapper;
        }

        @Nullable
        @Override
        public String toLineProtocol() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nonnull
        @Override
        public Long length() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The Batch Write Item.
     */
    public static final class BatchWriteItem {

        private WriteParameters writeParameters;

        private BatchWriteData data;

        public BatchWriteItem(@Nonnull final WriteParameters writeParameters, @Nonnull final BatchWriteData data) {
            Arguments.checkNotNull(writeParameters, "writeParameters");
            Arguments.checkNotNull(data, "data");
            this.writeParameters = writeParameters;
            this.data = data;
        }

        public long length() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nullable
        public String toLineProtocol() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("rawtypes")
    private final class ToWritePointsMaybe implements Function<BatchWriteItem, Maybe<Notification<Response>>> {

        private final Scheduler retryScheduler;

        private final WriteApi.RetryOptions retryOptions;

        private ToWritePointsMaybe(@Nonnull final Scheduler retryScheduler, @Nonnull final WriteApi.RetryOptions retryOptions) {
            this.retryScheduler = retryScheduler;
            this.retryOptions = retryOptions;
        }

        @Override
        public Maybe<Notification<Response>> apply(final BatchWriteItem batchWrite) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nonnull
        private WriteSuccessEvent toSuccessEvent(@Nonnull final BatchWriteItem batchWrite, final String lineProtocol) {
            return new WriteSuccessEvent(batchWrite.writeParameters.orgSafe(options), batchWrite.writeParameters.bucketSafe(options), batchWrite.writeParameters.precisionSafe(options), lineProtocol);
        }
    }

    /**
     * Add Jitter delay to upstream.
     *
     * @param scheduler    to use for timer operator
     * @param retryOptions with configured jitter interval
     * @param <T>          upstream type
     * @return Flowable with jitter delay
     */
    @Nonnull
    public static <T> FlowableTransformer<T, T> jitter(@Nonnull final Scheduler scheduler, @Nonnull final WriteApi.RetryOptions retryOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add Retry handler to upstream.
     *
     * @param retryScheduler for retry delay
     * @param retryOptions   with configured retry strategy
     * @param notify         to notify about retryable error
     * @return Flowable with retry handler
     */
    @Nonnull
    public static Function<Flowable<Throwable>, Publisher<?>> retry(@Nonnull final Scheduler retryScheduler, @Nonnull final WriteApi.RetryOptions retryOptions, @Nonnull final BiConsumer<Throwable, Long> notify) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void waitToCondition(final Supplier<Boolean> condition, final int millis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
