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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.client.FindOptions;
import com.influxdb.client.NotificationEndpointsApi;
import com.influxdb.client.domain.HTTPNotificationEndpoint;
import com.influxdb.client.domain.HTTPNotificationEndpoint.MethodEnum;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.LabelMapping;
import com.influxdb.client.domain.LabelResponse;
import com.influxdb.client.domain.LabelsResponse;
import com.influxdb.client.domain.NotificationEndpoint;
import com.influxdb.client.domain.NotificationEndpointBase;
import com.influxdb.client.domain.NotificationEndpointType;
import com.influxdb.client.domain.NotificationEndpointUpdate;
import com.influxdb.client.domain.NotificationEndpoints;
import com.influxdb.client.domain.PagerDutyNotificationEndpoint;
import com.influxdb.client.domain.SlackNotificationEndpoint;
import com.influxdb.client.service.NotificationEndpointsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (11/09/2019 09:23)
 */
final class NotificationEndpointsApiImpl extends AbstractRestClient implements NotificationEndpointsApi {

    private final NotificationEndpointsService service;

    NotificationEndpointsApiImpl(@Nonnull final NotificationEndpointsService service) {
        Arguments.checkNotNull(service, "notificationEndpointsService");
        this.service = service;
    }

    @Nonnull
    @Override
    public SlackNotificationEndpoint createSlackEndpoint(@Nonnull final String name, @Nonnull final String url, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public SlackNotificationEndpoint createSlackEndpoint(@Nonnull final String name, @Nonnull final String url, @Nullable final String token, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public PagerDutyNotificationEndpoint createPagerDutyEndpoint(@Nonnull final String name, @Nonnull final String clientURL, @Nonnull final String routingKey, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint createHTTPEndpoint(@Nonnull final String name, @Nonnull final String url, @Nonnull final MethodEnum method, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint createHTTPEndpointBasicAuth(@Nonnull final String name, @Nonnull final String url, @Nonnull final MethodEnum method, @Nonnull final String username, @Nonnull final String password, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint createHTTPEndpointBearer(@Nonnull final String name, @Nonnull final String url, @Nonnull final MethodEnum method, @Nonnull final String token, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Nonnull
    public NotificationEndpoint createEndpoint(@Nonnull final NotificationEndpoint notificationEndpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationEndpoint updateEndpoint(@Nonnull final NotificationEndpoint notificationEndpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationEndpoint updateEndpoint(@Nonnull final String endpointID, @Nonnull final NotificationEndpointUpdate notificationEndpointUpdate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteNotificationEndpoint(@Nonnull final NotificationEndpoint notificationEndpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteNotificationEndpoint(@Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<NotificationEndpoint> findNotificationEndpoints(@Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationEndpoints findNotificationEndpoints(@Nonnull final String orgID, @Nonnull final FindOptions findOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public SlackNotificationEndpoint cloneSlackEndpoint(@Nonnull final String name, @Nullable final String token, @Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public SlackNotificationEndpoint cloneSlackEndpoint(@Nonnull final String name, @Nullable final String token, @Nonnull final SlackNotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public PagerDutyNotificationEndpoint clonePagerDutyEndpoint(@Nonnull final String name, @Nonnull final String routingKey, @Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public PagerDutyNotificationEndpoint clonePagerDutyEndpoint(@Nonnull final String name, @Nonnull final String routingKey, @Nonnull final PagerDutyNotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint cloneHTTPEndpoint(@Nonnull final String name, @Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint cloneHTTPEndpoint(@Nonnull final String name, @Nonnull final HTTPNotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint cloneHTTPEndpointBasicAuth(@Nonnull final String name, @Nonnull final String username, @Nonnull final String password, @Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint cloneHTTPEndpointBasicAuth(@Nonnull final String name, @Nonnull final String username, @Nonnull final String password, @Nonnull final HTTPNotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint cloneHTTPEndpointBearer(@Nonnull final String name, @Nonnull final String token, @Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationEndpoint cloneHTTPEndpointBearer(@Nonnull final String name, @Nonnull final String token, @Nonnull final HTTPNotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private NotificationEndpoint cloneEndpoint(@Nonnull final String name, @Nonnull final NotificationEndpoint toCloneEndpoint, @Nonnull final NotificationEndpoint clonedEndpoint) {
        Arguments.checkNonEmpty(name, "name");
        Arguments.checkNotNull(toCloneEndpoint, "notificationEndpoint");
        clonedEndpoint.name(name).orgID(toCloneEndpoint.getOrgID()).description(toCloneEndpoint.getDescription()).status(toCloneEndpoint.getStatus()).type(toCloneEndpoint.getType());
        NotificationEndpoint created = createEndpoint(clonedEndpoint);
        getLabels(created).forEach(label -> addLabel(label, created));
        return created;
    }

    @Nonnull
    @Override
    public NotificationEndpoint findNotificationEndpointByID(@Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final NotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final NotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final NotificationEndpoint endpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String endpointID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
