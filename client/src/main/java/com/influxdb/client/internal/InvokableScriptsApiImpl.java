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
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.Cancellable;
import com.influxdb.client.InvokableScriptsApi;
import com.influxdb.client.InvokableScriptsQuery;
import com.influxdb.client.domain.Script;
import com.influxdb.client.domain.ScriptCreateRequest;
import com.influxdb.client.domain.ScriptInvocationParams;
import com.influxdb.client.domain.ScriptUpdateRequest;
import com.influxdb.client.domain.Scripts;
import com.influxdb.client.service.InvokableScriptsService;
import com.influxdb.internal.AbstractQueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.influxdb.query.internal.FluxCsvParser;
import com.influxdb.utils.Arguments;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (03/21/2022 07:54)
 */
final class InvokableScriptsApiImpl extends AbstractQueryApi implements InvokableScriptsApi {

    private final InvokableScriptsService service;

    InvokableScriptsApiImpl(@Nonnull final InvokableScriptsService service) {
        super(new FluxCsvParser(FluxCsvParser.ResponseMetadataMode.ONLY_NAMES));
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public Script createScript(@Nonnull final ScriptCreateRequest createRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Script updateScript(@Nonnull final String scriptId, @Nonnull final ScriptUpdateRequest updateRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Script> findScripts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Script> findScripts(@Nonnull final InvokableScriptsQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteScript(@Nonnull final String scriptId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<FluxTable> invokeScript(@Nonnull final String scriptId, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void invokeScript(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void invokeScript(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final BiConsumer<Cancellable, FluxRecord> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <M> List<M> invokeScript(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final Class<M> measurementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void invokeScript(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <M> void invokeScript(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final Class<M> measurementType, @Nonnull final BiConsumer<Cancellable, M> onNext, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String invokeScriptRaw(@Nonnull final String scriptId, @Nullable final Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void invokeScriptRaw(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final BiConsumer<Cancellable, String> onResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void invokeScriptRaw(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void query(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final FluxCsvParser.FluxResponseConsumer responseConsumer, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nonnull final Boolean asynchronously) {
        Arguments.checkNonEmpty(scriptId, "scriptId");
        Arguments.checkNotNull(responseConsumer, "responseConsumer");
        Arguments.checkNotNull(onError, "onError");
        Arguments.checkNotNull(onComplete, "onComplete");
        Arguments.checkNotNull(asynchronously, "asynchronously");
        Call<ResponseBody> queryCall = service.postScriptsIDInvokeResponseBody(scriptId, new ScriptInvocationParams().params(params));
        query(queryCall, responseConsumer, onError, onComplete, asynchronously);
    }

    private void queryRaw(@Nonnull final String scriptId, @Nullable final Map<String, Object> params, @Nonnull final BiConsumer<Cancellable, String> onResponse, @Nonnull final Consumer<? super Throwable> onError, @Nonnull final Runnable onComplete, @Nonnull final Boolean asynchronously) {
        Arguments.checkNonEmpty(scriptId, "scriptId");
        Arguments.checkNotNull(onResponse, "onResponse");
        Arguments.checkNotNull(onError, "onError");
        Arguments.checkNotNull(onComplete, "onComplete");
        Arguments.checkNotNull(asynchronously, "asynchronously");
        Call<ResponseBody> queryCall = service.postScriptsIDInvokeResponseBody(scriptId, new ScriptInvocationParams().params(params));
        queryRaw(queryCall, onResponse, onError, onComplete, asynchronously);
    }
}
