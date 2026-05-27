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

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.client.SourcesApi;
import com.influxdb.client.domain.Bucket;
import com.influxdb.client.domain.Buckets;
import com.influxdb.client.domain.HealthCheck;
import com.influxdb.client.domain.Source;
import com.influxdb.client.domain.Sources;
import com.influxdb.client.service.SourcesService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (18/09/2018 09:40)
 */
final class SourcesApiImpl extends AbstractRestClient implements SourcesApi {

    private static final Logger LOG = Logger.getLogger(SourcesApiImpl.class.getName());

    private final InfluxDBClientImpl influxDBClient;

    private final SourcesService service;

    SourcesApiImpl(@Nonnull final SourcesService service, @Nonnull final InfluxDBClientImpl influxDBClient) {
        Arguments.checkNotNull(service, "service");
        Arguments.checkNotNull(influxDBClient, "influxDBClient");
        this.service = service;
        this.influxDBClient = influxDBClient;
    }

    @Nonnull
    @Override
    public Source createSource(@Nonnull final Source source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Source updateSource(@Nonnull final Source source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteSource(@Nonnull final Source source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteSource(@Nonnull final String sourceID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Source cloneSource(@Nonnull final String clonedName, @Nonnull final String sourceID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Source cloneSource(@Nonnull final String clonedName, @Nonnull final Source source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Source findSourceByID(@Nonnull final String sourceID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Source> findSources() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    @Override
    public List<Bucket> findBucketsBySource(@Nonnull final Source source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Bucket> findBucketsBySourceID(@Nonnull final String sourceID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HealthCheck health(@Nonnull final Source source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HealthCheck health(@Nonnull final String sourceID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
