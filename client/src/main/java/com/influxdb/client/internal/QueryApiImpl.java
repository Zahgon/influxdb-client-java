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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.Cancellable;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.QueryApi;
import com.influxdb.client.domain.Dialect;
import com.influxdb.client.domain.Query;
import com.influxdb.client.service.QueryService;
import com.influxdb.internal.AbstractQueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.influxdb.query.internal.FluxCsvParser;
import com.influxdb.utils.Arguments;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (17/10/2018 10:50)
 */
final class QueryApiImpl extends AbstractQueryApi implements QueryApi {

    private static final Logger LOG = Logger.getLogger(QueryApiImpl.class.getName());

    private final QueryService service;

    private final InfluxDBClientOptions options;

    QueryApiImpl(@Nonnull final QueryService service, @Nonnull final InfluxDBClientOptions options) {
        Arguments.checkNotNull(service, "service");
        Arguments.checkNotNull(options, "options");
        this.service = service;
        this.options = options;
    }

    @Nonnull
    @Override
    public List<FluxTable> query(@Nonnull final String query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<FluxTable> query(@Nonnull final String query, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<FluxTable> query(@Nonnull final String query, @Nonnull final String org, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<FluxTable> query(@Nonnull final Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<FluxTable> query(@Nonnull final Query query, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <M> List<M> query(@Nonnull final String query, @Nonnull final Class<M> measurementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <M> List<M> query(@Nonnull final String query, @Nonnull final String org, @Nonnull final Class<M> measurementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <M> List<M> query(@Nonnull final String query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <M> List<M> query(@Nonnull final Query query, @Nonnull final Class<M> measurementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <M> List<M> query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final Class<M> measurementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final Query query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final Query query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final Query query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final Query query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final Query query, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final String query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final Query query, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final String query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final String query, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final String query, @Nullable final Dialect dialect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final String org, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String queryRaw(@Nonnull final Query query, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final Query query, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final Query query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final Query query, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final Query query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final String query, @Nullable final Dialect dialect, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final Query query, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryRaw(@Nonnull final Query query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void query(@Nonnull final Query query, @Nonnull final String org, @Nonnull final FluxCsvParser.FluxResponseConsumer responseConsumer, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nonnull final Boolean asynchronously) {
        Call<ResponseBody> queryCall = service.postQueryResponseBody(null, null, null, org, null, query.dialect(AbstractInfluxDBClient.DEFAULT_DIALECT));
        LOG.log(Level.FINEST, "Prepare query \"{0}\" with dialect \"{1}\" on organization \"{2}\".", new Object[] { query, query.getDialect(), org });
        query(queryCall, responseConsumer, onError, onComplete, asynchronously);
    }

    private void queryRaw(@Nonnull final Query query, @Nonnull final String org, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nonnull final Boolean asynchronously) {
        Call<ResponseBody> queryCall = service.postQueryResponseBody(null, null, null, org, null, query);
        LOG.log(Level.FINEST, "Prepare raw query \"{0}\" with dialect \"{1}\" on organization \"{2}\".", new Object[] { query, query.getDialect(), org });
        queryRaw(queryCall, onResponse, onError, onComplete, asynchronously);
    }
}
