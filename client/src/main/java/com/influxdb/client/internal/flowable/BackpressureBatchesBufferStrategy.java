package com.influxdb.client.internal.flowable;

import java.util.Collections;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import com.influxdb.client.internal.AbstractWriteClient;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.FlowableOperator;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * The backpressure strategy which uses total sum of {@link AbstractWriteClient.BatchWriteItem#length()}
 * to determine backpressure boundary.
 * <p>
 * The original strategy {@link FlowableOnBackpressureBufferStrategy} uses only count of elements.
 *
 * @see FlowableOnBackpressureBufferStrategy
 */
public final class BackpressureBatchesBufferStrategy implements FlowableOperator<AbstractWriteClient.BatchWriteItem, AbstractWriteClient.BatchWriteItem> {

    final long bufferSize;

    final Consumer<List<String>> onOverflow;

    final BackpressureOverflowStrategy strategy;

    final boolean captureBackpressureData;

    public BackpressureBatchesBufferStrategy(long bufferSize, Consumer<List<String>> onOverflow, BackpressureOverflowStrategy strategy) {
        this(bufferSize, onOverflow, strategy, false);
    }

    public BackpressureBatchesBufferStrategy(long bufferSize, Consumer<List<String>> onOverflow, BackpressureOverflowStrategy strategy, boolean captureBackpressureData) {
        this.bufferSize = bufferSize;
        this.onOverflow = onOverflow;
        this.strategy = strategy;
        this.captureBackpressureData = captureBackpressureData;
    }

    @Override
    @NonNull
    public Subscriber<? super AbstractWriteClient.BatchWriteItem> apply(@NonNull final Subscriber<? super AbstractWriteClient.BatchWriteItem> subscriber) throws Throwable {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class OnBackpressureBufferStrategySubscriber extends AtomicInteger implements FlowableSubscriber<AbstractWriteClient.BatchWriteItem>, Subscription {

        private static final long serialVersionUID = 3240706908776709697L;

        final Subscriber<? super AbstractWriteClient.BatchWriteItem> downstream;

        final BackpressureOverflowStrategy strategy;

        final long bufferSize;

        final AtomicLong requested;

        final Deque<AbstractWriteClient.BatchWriteItem> deque;

        Subscription upstream;

        volatile boolean cancelled;

        volatile boolean done;

        Throwable error;

        final Consumer<List<String>> onOverflow;

        final boolean captureBackpressureData;

        OnBackpressureBufferStrategySubscriber(Subscriber<? super AbstractWriteClient.BatchWriteItem> actual, Consumer<List<String>> onOverflow, BackpressureOverflowStrategy strategy, long bufferSize, boolean captureBackpressureData) {
            this.downstream = actual;
            this.onOverflow = onOverflow;
            this.strategy = strategy;
            this.bufferSize = bufferSize;
            this.captureBackpressureData = captureBackpressureData;
            this.requested = new AtomicLong();
            this.deque = new ArrayDeque<>();
        }

        @Override
        public void onSubscribe(@NonNull Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onNext(AbstractWriteClient.BatchWriteItem t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Captures snapshot of a single batch item for overflow handling.
         *
         * @param item the batch item to capture
         * @return list of line protocol points from the item
         */
        List<String> captureBatch(AbstractWriteClient.BatchWriteItem item) {
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
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void clear(Deque<AbstractWriteClient.BatchWriteItem> dq) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
