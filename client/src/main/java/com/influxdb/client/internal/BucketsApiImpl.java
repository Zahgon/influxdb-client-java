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
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.client.BucketsApi;
import com.influxdb.client.BucketsQuery;
import com.influxdb.client.FindOptions;
import com.influxdb.client.domain.AddResourceMemberRequestBody;
import com.influxdb.client.domain.Bucket;
import com.influxdb.client.domain.BucketRetentionRules;
import com.influxdb.client.domain.Buckets;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.LabelMapping;
import com.influxdb.client.domain.LabelResponse;
import com.influxdb.client.domain.LabelsResponse;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.PatchBucketRequest;
import com.influxdb.client.domain.PatchRetentionRule;
import com.influxdb.client.domain.PostBucketRequest;
import com.influxdb.client.domain.ResourceMember;
import com.influxdb.client.domain.ResourceMembers;
import com.influxdb.client.domain.ResourceOwner;
import com.influxdb.client.domain.ResourceOwners;
import com.influxdb.client.domain.User;
import com.influxdb.client.service.BucketsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (13/09/2018 10:47)
 */
final class BucketsApiImpl extends AbstractRestClient implements BucketsApi {

    private static final Logger LOG = Logger.getLogger(BucketsApiImpl.class.getName());

    private final BucketsService service;

    BucketsApiImpl(@Nonnull final BucketsService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public Bucket findBucketByID(@Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    @Override
    public Bucket findBucketByName(@Nonnull final String bucketName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Bucket> findBuckets() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Nonnull
    public Buckets findBuckets(@Nonnull final FindOptions findOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    public List<Bucket> findBucketsByOrg(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Bucket> findBucketsByOrgName(@Nullable final String orgName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Bucket> findBuckets(@Nonnull final BucketsQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket createBucket(@Nonnull final String name, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket createBucket(@Nonnull final String name, @Nullable final BucketRetentionRules bucketRetentionRules, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket createBucket(@Nonnull final String name, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket createBucket(@Nonnull final String name, @Nullable final BucketRetentionRules bucketRetentionRules, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket createBucket(@Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket createBucket(@Nonnull final PostBucketRequest bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket updateBucket(@Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteBucket(@Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteBucket(@Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket cloneBucket(@Nonnull final String clonedName, @Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Bucket cloneBucket(@Nonnull final String clonedName, @Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final User member, @Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final String memberID, @Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final User member, @Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final String memberID, @Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final User owner, @Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final String ownerID, @Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final User owner, @Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final String ownerID, @Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final Bucket bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String bucketID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private Buckets findBuckets(@Nullable final String orgName, @Nonnull final FindOptions findOptions) {
        Call<Buckets> bucketsCall = service.getBuckets(null, findOptions.getOffset(), findOptions.getLimit(), findOptions.getAfter(), orgName, null, null, null);
        return execute(bucketsCall);
    }
}
