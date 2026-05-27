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
package com.influxdb.client.flux;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.utils.Arguments;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/**
 * FluxConnectionOptions are used to configure queries to the Flux.
 *
 * @author Jakub Bednar (bednar@github) (26/06/2018 08:59)
 */
@ThreadSafe
public final class FluxConnectionOptions {

    private final String url;

    private OkHttpClient.Builder okHttpClient;

    private Map<String, String> parameters;

    private FluxConnectionOptions(@Nonnull final Builder builder) {
        Arguments.checkNotNull(builder, "FluxConnectionOptions.Builder");
        url = builder.url;
        okHttpClient = builder.okHttpClient;
        parameters = builder.parameters;
    }

    /**
     * Creates a builder instance.
     *
     * @return a builder
     */
    @Nonnull
    public static FluxConnectionOptions.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder builder(final String connectionString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the url to connect to Flux
     * @see FluxConnectionOptions.Builder#url(String)
     */
    @Nonnull
    public String getUrl() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return HTTP client to use for communication with Flux
     * @see FluxConnectionOptions.Builder#okHttpClient(OkHttpClient.Builder)
     */
    @Nonnull
    public OkHttpClient.Builder getOkHttpClient() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return returns the map with connection string parameters
     */
    public Map<String, String> getParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A builder for {@code FluxConnectionOptions}.
     */
    @NotThreadSafe
    public static class Builder {

        private String url;

        private OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder().protocols(Collections.singletonList(Protocol.HTTP_1_1));

        private Map<String, String> parameters = new HashMap<>();

        /**
         * Set the url to connect to Flux.
         *
         * @param url the url to connect to Flux. It must be defined.
         * @return {@code this}
         */
        @Nonnull
        public Builder url(@Nonnull final String url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder withParam(@Nonnull final String paramName, @Nullable final String value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set the HTTP client to use for communication with Flux.
         *
         * @param okHttpClient the HTTP client to use.
         * @return {@code this}
         */
        @Nonnull
        public Builder okHttpClient(@Nonnull final OkHttpClient.Builder okHttpClient) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Build an instance of FluxConnectionOptions.
         *
         * @return {@link FluxConnectionOptions}
         */
        @Nonnull
        public FluxConnectionOptions build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
