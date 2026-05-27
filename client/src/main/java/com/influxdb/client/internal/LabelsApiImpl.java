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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.client.LabelsApi;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.LabelCreateRequest;
import com.influxdb.client.domain.LabelResponse;
import com.influxdb.client.domain.LabelUpdate;
import com.influxdb.client.domain.LabelsResponse;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.service.LabelsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (28/01/2019 10:48)
 */
final class LabelsApiImpl extends AbstractRestClient implements LabelsApi {

    private static final Logger LOG = Logger.getLogger(LabelsApiImpl.class.getName());

    private final LabelsService service;

    LabelsApiImpl(@Nonnull final LabelsService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public Label createLabel(@Nonnull final String name, @Nonnull final Map<String, String> properties, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Label createLabel(@Nonnull final LabelCreateRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Label updateLabel(@Nonnull final Label label) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Label updateLabel(@Nonnull final String labelID, @Nonnull final LabelUpdate labelUpdate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Label cloneLabel(@Nonnull final String clonedName, @Nonnull final String labelID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Label cloneLabel(@Nonnull final String clonedName, @Nonnull final Label label) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Label findLabelByID(@Nonnull final String labelID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> findLabels() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> findLabelsByOrg(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> findLabelsByOrgId(@Nullable final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
