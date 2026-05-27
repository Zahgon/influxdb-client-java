package com.influxdb.client.internal.flowable;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Scheduler.Worker;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Buffered flowable which is able to flush the buffer by the count,
 * time and also by the request by associated {@code publisher}.
 *
 * @param <T> the upstream value type
 * @param <U> the output value type
 * @see FlowableBufferTimed
 */
public final class FlowableBufferTimedFlushable<T, U extends List<? super T>> extends Flowable<U> implements FlowableTransformer<T, U> {

    final Publisher<T> source;

    final Publisher<Boolean> flusher;

    final long timespan;

    final long timeskip;

    final TimeUnit unit;

    final Scheduler scheduler;

    final Supplier<U> bufferSupplier;

    final int maxSize;

    final boolean restartTimerOnMaxSize;

    public FlowableBufferTimedFlushable(Publisher<T> source, Publisher<Boolean> flusher, long timespan, TimeUnit unit, int maxSize, Scheduler scheduler, Supplier<U> bufferSupplier) {
        this.source = source;
        this.flusher = flusher;
        this.timespan = timespan;
        this.timeskip = timespan;
        this.unit = unit;
        this.scheduler = scheduler;
        this.bufferSupplier = bufferSupplier;
        this.maxSize = maxSize;
        this.restartTimerOnMaxSize = true;
    }

    @Override
    @NonNull
    public Publisher<U> apply(@NonNull final Flowable<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void subscribeActual(@NonNull final Subscriber<? super U> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {

        final Supplier<U> bufferSupplier;

        final long timespan;

        final TimeUnit unit;

        final int maxSize;

        final boolean restartTimerOnMaxSize;

        final Worker w;

        final Publisher<Boolean> flusher;

        U buffer;

        Disposable timer;

        Subscription upstream;

        long producerIndex;

        long consumerIndex;

        BufferExactBoundedSubscriber(Subscriber<? super U> actual, Supplier<U> bufferSupplier, long timespan, TimeUnit unit, int maxSize, boolean restartOnMaxSize, Worker w, Publisher<Boolean> flusher) {
            super(actual, new MpscLinkedQueue<>());
            this.bufferSupplier = bufferSupplier;
            this.timespan = timespan;
            this.unit = unit;
            this.maxSize = maxSize;
            this.restartTimerOnMaxSize = restartOnMaxSize;
            this.w = w;
            this.flusher = flusher;
        }

        @Override
        public void onSubscribe(@NonNull Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onNext(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onError(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean accept(Subscriber<? super U> a, U v) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void dispose() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean isDisposed() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
