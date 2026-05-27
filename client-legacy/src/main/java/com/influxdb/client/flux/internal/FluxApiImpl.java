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
package com.influxdb.client.flux.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.Cancellable;
import com.influxdb.LogLevel;
import com.influxdb.client.flux.FluxClient;
import com.influxdb.client.flux.FluxConnectionOptions;
import com.influxdb.internal.AbstractQueryApi;
import com.influxdb.internal.UserAgentInterceptor;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.influxdb.query.internal.FluxCsvParser.FluxResponseConsumer;
import com.influxdb.query.internal.FluxCsvParser.FluxResponseConsumerTable;
import com.influxdb.utils.Arguments;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * @author Jakub Bednar (bednar@github) (03/10/2018 14:20)
 */
public class FluxApiImpl extends AbstractQueryApi implements FluxClient {

    private final FluxService fluxService;

    private final HttpLoggingInterceptor loggingInterceptor;

    private final OkHttpClient okHttpClient;

    public FluxApiImpl(@Nonnull final FluxConnectionOptions options) {
        Arguments.checkNotNull(options, "options");
        this.loggingInterceptor = new HttpLoggingInterceptor();
        String logLevelParam = options.getParameters().get("logLevel");
        if (logLevelParam == null) {
            this.loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        } else {
            this.loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.valueOf(logLevelParam));
        }
        this.okHttpClient = options.getOkHttpClient().addInterceptor(new UserAgentInterceptor("java")).addInterceptor(this.loggingInterceptor).build();
        Retrofit.Builder serviceBuilder = new Retrofit.Builder().baseUrl(options.getUrl()).client(this.okHttpClient);
        this.fluxService = serviceBuilder.build().create(FluxService.class);
    }

    @Nonnull
    @Override
    public List<FluxTable> query(@Nonnull final String query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <M> List<M> query(@Nonnull final String query, @Nonnull final Class<M> measurementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final String query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final String query, @Nullable final String dialect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final String dialect, @Nonnull final BiConsumer<Cancellable, String> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final String dialect, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final String dialect, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Boolean ping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Nonnull
    public String version() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LogLevel getLogLevel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public FluxClient setLogLevel(@Nonnull final LogLevel logLevel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Closes the client, initiates shutdown, no new running calls are accepted during shutdown.
     */
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void query(@Nonnull final String query, @Nonnull final String dialect, @Nonnull final FluxResponseConsumer responseConsumer, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nonnull final Boolean asynchronously) {
        Call<ResponseBody> queryCall = fluxService.query(createBody(dialect, query));
        query(queryCall, responseConsumer, onError, onComplete, asynchronously);
    }

    private void queryRaw(@Nonnull final String query, @Nullable final String dialect, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nonnull final Boolean asynchronously) {
        Call<ResponseBody> queryCall = fluxService.query(createBody(dialect, query));
        queryRaw(queryCall, onResponse, onError, onComplete, asynchronously);
    }
}
