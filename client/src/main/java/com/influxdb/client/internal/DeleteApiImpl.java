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

import java.time.OffsetDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import com.influxdb.client.DeleteApi;
import com.influxdb.client.domain.Bucket;
import com.influxdb.client.domain.DeletePredicateRequest;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.service.DeleteService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Pavlina Rolincova (rolincova@github) (25/10/2019).
 */
public class DeleteApiImpl extends AbstractRestClient implements DeleteApi {

    private static final Logger LOG = Logger.getLogger(DeleteApiImpl.class.getName());

    private final DeleteService service;

    DeleteApiImpl(@Nonnull final DeleteService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Override
    public void delete(@Nonnull final OffsetDateTime start, @Nonnull final OffsetDateTime stop, @Nonnull final String predicate, @Nonnull final Bucket bucket, @Nonnull final Organization org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(@Nonnull final OffsetDateTime start, @Nonnull final OffsetDateTime stop, @Nonnull final String predicate, @Nonnull final String bucket, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(@Nonnull final DeletePredicateRequest predicate, @Nonnull final String bucket, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
