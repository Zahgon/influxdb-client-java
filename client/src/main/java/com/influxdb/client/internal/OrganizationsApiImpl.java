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
import com.influxdb.client.OrganizationsApi;
import com.influxdb.client.OrganizationsQuery;
import com.influxdb.client.domain.AddResourceMemberRequestBody;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.Organizations;
import com.influxdb.client.domain.PatchOrganizationRequest;
import com.influxdb.client.domain.PostOrganizationRequest;
import com.influxdb.client.domain.ResourceMember;
import com.influxdb.client.domain.ResourceMembers;
import com.influxdb.client.domain.ResourceOwner;
import com.influxdb.client.domain.ResourceOwners;
import com.influxdb.client.domain.SecretKeys;
import com.influxdb.client.domain.SecretKeysResponse;
import com.influxdb.client.domain.User;
import com.influxdb.client.service.OrganizationsService;
import com.influxdb.client.service.SecretsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (12/09/2018 08:57)
 */
final class OrganizationsApiImpl extends AbstractRestClient implements OrganizationsApi {

    private static final Logger LOG = Logger.getLogger(OrganizationsApiImpl.class.getName());

    private final OrganizationsService service;

    private final SecretsService secretsService;

    OrganizationsApiImpl(@Nonnull final OrganizationsService service, @Nonnull final SecretsService secretsService) {
        Arguments.checkNotNull(service, "service");
        Arguments.checkNotNull(secretsService, "secretsService");
        this.service = service;
        this.secretsService = secretsService;
    }

    @Nonnull
    @Override
    public Organization findOrganizationByID(@Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Organization> findOrganizations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Organization> findOrganizations(@Nonnull final OrganizationsQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Organization createOrganization(@Nonnull final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Organization createOrganization(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Organization updateOrganization(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOrganization(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOrganization(@Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Organization cloneOrganization(@Nonnull final String clonedName, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Organization cloneOrganization(@Nonnull final String clonedName, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SecretKeysResponse getSecrets(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SecretKeysResponse getSecrets(@Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void putSecrets(@Nonnull final Map<String, String> secrets, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void putSecrets(@Nonnull final Map<String, String> secrets, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteSecrets(@Nonnull final List<String> secrets, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteSecrets(@Nonnull final List<String> secrets, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteSecrets(@Nonnull final SecretKeys secretKeys, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final User member, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final String memberID, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final User member, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final String memberID, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final User owner, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final String ownerID, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final User owner, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final String ownerID, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
