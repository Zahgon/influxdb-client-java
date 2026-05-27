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

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/**
 * @author Jakub Bednar (bednar@github) (15/10/2018 11:26)
 */
public class GzipInterceptor implements Interceptor {

    private static final Pattern CONTENT_PATTERN = Pattern.compile(".*/write", Pattern.CASE_INSENSITIVE);

    private static final Pattern ACCEPT_PATTERN = Pattern.compile(".*/query", Pattern.CASE_INSENSITIVE);

    private AtomicBoolean enabled = new AtomicBoolean(false);

    @Nonnull
    @Override
    public Response intercept(@Nonnull final Chain chain) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void enableGzip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isEnabledGzip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void disableGzip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private Request.Builder addHeader(@Nonnull final Request request, @Nonnull final Request.Builder builder, @Nonnull final String headerName, @Nonnull final String headerValue) {
        // do not override specified headers
        if (request.header(headerName) != null) {
            return builder;
        }
        return builder.header(headerName, headerValue);
    }

    @Nonnull
    private RequestBody gzip(@Nonnull final RequestBody body) {
        return new RequestBody() {

            @Override
            public MediaType contentType() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public long contentLength() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void writeTo(@Nonnull final BufferedSink sink) throws IOException {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }
}
