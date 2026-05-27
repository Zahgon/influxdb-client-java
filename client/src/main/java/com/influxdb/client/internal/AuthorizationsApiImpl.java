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
import com.influxdb.client.AuthorizationsApi;
import com.influxdb.client.domain.Authorization;
import com.influxdb.client.domain.AuthorizationPostRequest;
import com.influxdb.client.domain.AuthorizationUpdateRequest;
import com.influxdb.client.domain.Authorizations;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.Permission;
import com.influxdb.client.domain.User;
import com.influxdb.client.service.AuthorizationsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (17/09/2018 12:00)
 */
final class AuthorizationsApiImpl extends AbstractRestClient implements AuthorizationsApi {

    private static final Logger LOG = Logger.getLogger(AuthorizationsApiImpl.class.getName());

    private final AuthorizationsService service;

    AuthorizationsApiImpl(@Nonnull final AuthorizationsService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public Authorization createAuthorization(@Nonnull final Organization organization, @Nonnull final List<Permission> permissions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Authorization createAuthorization(@Nonnull final String orgID, @Nonnull final List<Permission> permissions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Authorization createAuthorization(@Nonnull final Authorization authorization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Nonnull
    public Authorization createAuthorization(@Nonnull final AuthorizationPostRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Authorization> findAuthorizations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Authorization findAuthorizationByID(@Nonnull final String authorizationID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Authorization> findAuthorizationsByUser(@Nonnull final User user) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Authorization> findAuthorizationsByUserID(@Nullable final String userID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Authorization> findAuthorizationsByUserName(@Nullable final String userName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Authorization> findAuthorizationsByOrg(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Authorization> findAuthorizationsByOrgID(@Nullable final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Authorization updateAuthorization(@Nonnull final Authorization authorization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Nonnull
    public Authorization updateAuthorization(@Nonnull final String authorizationID, @Nonnull final AuthorizationUpdateRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteAuthorization(@Nonnull final Authorization authorization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteAuthorization(@Nonnull final String authorizationID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Authorization cloneAuthorization(@Nonnull final String authorizationID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Authorization cloneAuthorization(@Nonnull final Authorization authorization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private List<Authorization> findAuthorizations(@Nullable final String userID, @Nullable final String userName, @Nullable final String orgID) {
        Call<Authorizations> authorizationsCall = service.getAuthorizations(null, userID, userName, orgID, null);
        Authorizations authorizations = execute(authorizationsCall);
        LOG.log(Level.FINEST, "findAuthorizations found: {0}", authorizations);
        return authorizations.getAuthorizations();
    }
}
