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

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.LogLevel;
import com.influxdb.client.AuthorizationsApi;
import com.influxdb.client.BucketsApi;
import com.influxdb.client.ChecksApi;
import com.influxdb.client.DashboardsApi;
import com.influxdb.client.DeleteApi;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.InfluxQLQueryApi;
import com.influxdb.client.InvokableScriptsApi;
import com.influxdb.client.LabelsApi;
import com.influxdb.client.NotificationEndpointsApi;
import com.influxdb.client.NotificationRulesApi;
import com.influxdb.client.OrganizationsApi;
import com.influxdb.client.QueryApi;
import com.influxdb.client.ScraperTargetsApi;
import com.influxdb.client.SourcesApi;
import com.influxdb.client.TasksApi;
import com.influxdb.client.TelegrafsApi;
import com.influxdb.client.UsersApi;
import com.influxdb.client.VariablesApi;
import com.influxdb.client.WriteApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.WriteOptions;
import com.influxdb.client.domain.HealthCheck;
import com.influxdb.client.domain.IsOnboarding;
import com.influxdb.client.domain.OnboardingRequest;
import com.influxdb.client.domain.OnboardingResponse;
import com.influxdb.client.domain.Ready;
import com.influxdb.client.service.AuthorizationsService;
import com.influxdb.client.service.BucketsService;
import com.influxdb.client.service.ChecksService;
import com.influxdb.client.service.DashboardsService;
import com.influxdb.client.service.DeleteService;
import com.influxdb.client.service.InfluxQLQueryService;
import com.influxdb.client.service.InvokableScriptsService;
import com.influxdb.client.service.LabelsService;
import com.influxdb.client.service.NotificationEndpointsService;
import com.influxdb.client.service.NotificationRulesService;
import com.influxdb.client.service.OrganizationsService;
import com.influxdb.client.service.QueryService;
import com.influxdb.client.service.ReadyService;
import com.influxdb.client.service.ScraperTargetsService;
import com.influxdb.client.service.SecretsService;
import com.influxdb.client.service.SetupService;
import com.influxdb.client.service.SourcesService;
import com.influxdb.client.service.TasksService;
import com.influxdb.client.service.TelegrafsService;
import com.influxdb.client.service.UsersService;
import com.influxdb.client.service.VariablesService;
import com.influxdb.client.service.WriteService;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.exceptions.UnprocessableEntityException;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (11/10/2018 09:36)
 */
public final class InfluxDBClientImpl extends AbstractInfluxDBClient implements InfluxDBClient {

    private static final Logger LOG = Logger.getLogger(InfluxDBClientImpl.class.getName());

    private final SetupService setupService;

    private final ReadyService readyService;

    public InfluxDBClientImpl(@Nonnull final InfluxDBClientOptions options) {
        super(options, "java");
        setupService = retrofit.create(SetupService.class);
        readyService = retrofit.create(ReadyService.class);
    }

    @Nonnull
    @Override
    public QueryApi getQueryApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public WriteApi getWriteApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public WriteApi getWriteApi(@Nonnull final WriteOptions writeOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public WriteApi makeWriteApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    @SuppressWarnings("MagicNumber")
    public WriteApi makeWriteApi(@Nonnull final WriteOptions writeOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public WriteApiBlocking getWriteApiBlocking() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public AuthorizationsApi getAuthorizationsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public BucketsApi getBucketsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public OrganizationsApi getOrganizationsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public SourcesApi getSourcesApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public TasksApi getTasksApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public UsersApi getUsersApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ScraperTargetsApi getScraperTargetsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public TelegrafsApi getTelegrafsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelsApi getLabelsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public VariablesApi getVariablesApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public DashboardsApi getDashboardsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ChecksApi getChecksApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationEndpointsApi getNotificationEndpointsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationRulesApi getNotificationRulesApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public DeleteApi getDeleteApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InvokableScriptsApi getInvokableScriptsApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxQLQueryApi getInfluxQLQueryApi() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public <S> S getService(@Nonnull final Class<S> service) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HealthCheck health() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Boolean ping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String version() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    @Override
    public Ready ready() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public OnboardingResponse onBoarding(@Nonnull final OnboardingRequest onboarding) throws UnprocessableEntityException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Boolean isOnboardingAllowed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LogLevel getLogLevel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxDBClient setLogLevel(@Nonnull final LogLevel logLevel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxDBClient enableGzip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxDBClient disableGzip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isGzipEnabled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
