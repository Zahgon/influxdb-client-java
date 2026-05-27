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

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.client.TelegrafsApi;
import com.influxdb.client.domain.AddResourceMemberRequestBody;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.LabelMapping;
import com.influxdb.client.domain.LabelResponse;
import com.influxdb.client.domain.LabelsResponse;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.ResourceMember;
import com.influxdb.client.domain.ResourceMembers;
import com.influxdb.client.domain.ResourceOwner;
import com.influxdb.client.domain.ResourceOwners;
import com.influxdb.client.domain.Telegraf;
import com.influxdb.client.domain.TelegrafPlugin;
import com.influxdb.client.domain.TelegrafPluginRequest;
import com.influxdb.client.domain.TelegrafPluginRequestPlugins;
import com.influxdb.client.domain.TelegrafRequestMetadata;
import com.influxdb.client.domain.Telegrafs;
import com.influxdb.client.domain.User;
import com.influxdb.client.service.TelegrafsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (28/02/2019 10:25)
 */
final class TelegrafsApiImpl extends AbstractRestClient implements TelegrafsApi {

    private static final Logger LOG = Logger.getLogger(TelegrafsApiImpl.class.getName());

    private final TelegrafsService service;

    TelegrafsApiImpl(@Nonnull final TelegrafsService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public Telegraf createTelegraf(@Nonnull final String name, @Nullable final String description, @Nonnull final Organization org, @Nonnull final Collection<TelegrafPlugin> plugins) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf createTelegraf(@Nonnull final String name, @Nullable final String description, @Nonnull final Organization org, @Nonnull final Map<String, Object> agentConfiguration, @Nonnull final Collection<TelegrafPlugin> plugins) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf createTelegraf(@Nonnull final String name, @Nullable final String description, @Nonnull final String orgID, @Nonnull final Collection<TelegrafPlugin> plugins) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Telegraf createTelegraf(@Nonnull final String name, @Nullable final String description, @Nonnull final String orgID, @Nonnull final Map<String, Object> agentConfiguration, @Nonnull final Collection<TelegrafPlugin> plugins) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf createTelegraf(@Nonnull final String name, @Nullable final String description, @Nonnull final String orgID, @Nonnull final String config, @Nullable final TelegrafRequestMetadata metadata) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf createTelegraf(@Nonnull final String name, @Nullable final String description, @Nonnull final Organization org, @Nonnull final String config, @Nullable final TelegrafRequestMetadata metadata) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf createTelegraf(@Nonnull final TelegrafPluginRequest telegrafPluginRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Nonnull
    @SuppressWarnings("MagicNumber")
    public HashMap<String, Object> createAgentConfiguration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf updateTelegraf(@Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf updateTelegraf(@Nonnull final String telegrafID, @Nonnull final TelegrafPluginRequest telegrafPluginRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteTelegraf(@Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteTelegraf(@Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf cloneTelegraf(@Nonnull final String clonedName, @Nonnull final String telegrafConfigID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf cloneTelegraf(@Nonnull final String clonedName, @Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Telegraf findTelegrafByID(@Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Telegraf> findTelegrafs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Telegraf> findTelegrafsByOrg(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Telegraf> findTelegrafsByOrgId(@Nullable final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String getTOML(@Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public String getTOML(@Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final User member, @Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final String memberID, @Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final User member, @Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final String memberID, @Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final User owner, @Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final String ownerID, @Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final User owner, @Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final String ownerID, @Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final Telegraf telegraf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String telegrafID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private TelegrafPluginRequest toTelegrafRequest(@Nonnull final Telegraf telegraf) {
        Arguments.checkNotNull(telegraf, "telegraf");
        TelegrafPluginRequest telegrafRequest = new TelegrafPluginRequest();
        telegrafRequest.setName(telegraf.getName());
        telegrafRequest.setDescription(telegraf.getDescription());
        telegrafRequest.setConfig(telegraf.getConfig());
        telegrafRequest.setMetadata(telegraf.getMetadata());
        telegrafRequest.setOrgID(telegraf.getOrgID());
        return telegrafRequest;
    }
}
