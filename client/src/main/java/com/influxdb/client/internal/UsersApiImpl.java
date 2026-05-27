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
import com.influxdb.client.UsersApi;
import com.influxdb.client.domain.PasswordResetBody;
import com.influxdb.client.domain.PostUser;
import com.influxdb.client.domain.User;
import com.influxdb.client.domain.Users;
import com.influxdb.client.service.UsersService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import okhttp3.Credentials;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (11/09/2018 10:16)
 */
final class UsersApiImpl extends AbstractRestClient implements UsersApi {

    private static final Logger LOG = Logger.getLogger(UsersApiImpl.class.getName());

    private final UsersService service;

    UsersApiImpl(@Nonnull final UsersService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public User findUserByID(@Nonnull final String userID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<User> findUsers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public User createUser(@Nonnull final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public User createUser(@Nonnull final User user) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public User updateUser(@Nonnull final User user) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void updateUserPassword(@Nonnull final User user, @Nonnull final String oldPassword, @Nonnull final String newPassword) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void updateUserPassword(@Nonnull final String userID, @Nonnull final String oldPassword, @Nonnull final String newPassword) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteUser(@Nonnull final User user) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteUser(@Nonnull final String userID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public User cloneUser(@Nonnull final String clonedName, @Nonnull final String userID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public User cloneUser(@Nonnull final String clonedName, @Nonnull final User user) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public User me() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void meUpdatePassword(@Nonnull final String oldPassword, @Nonnull final String newPassword) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void updateUserPassword(@Nonnull final String userID, @Nonnull final String userName, @Nonnull final String oldPassword, @Nonnull final String newPassword) {
        Arguments.checkNotNull(userID, "User ID");
        Arguments.checkNotNull(userName, "Username");
        Arguments.checkNotNull(oldPassword, "old password");
        Arguments.checkNotNull(newPassword, "new password");
        String credentials = Credentials.basic(userName, oldPassword);
        PasswordResetBody resetBody = new PasswordResetBody().password(newPassword);
        Call<Void> call = service.postUsersIDPassword(userID, resetBody, null, credentials);
        execute(call);
    }
}
