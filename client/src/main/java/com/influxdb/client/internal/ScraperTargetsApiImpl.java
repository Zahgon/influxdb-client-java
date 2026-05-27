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
import com.influxdb.client.ScraperTargetsApi;
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
import com.influxdb.client.domain.ScraperTargetRequest;
import com.influxdb.client.domain.ScraperTargetResponse;
import com.influxdb.client.domain.ScraperTargetResponses;
import com.influxdb.client.domain.User;
import com.influxdb.client.service.ScraperTargetsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (22/01/2019 08:17)
 */
final class ScraperTargetsApiImpl extends AbstractRestClient implements ScraperTargetsApi {

    private static final Logger LOG = Logger.getLogger(ScraperTargetsApiImpl.class.getName());

    private final ScraperTargetsService service;

    ScraperTargetsApiImpl(@Nonnull final ScraperTargetsService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public ScraperTargetResponse createScraperTarget(@Nonnull final ScraperTargetRequest scraperTargetRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ScraperTargetResponse createScraperTarget(@Nonnull final String name, @Nonnull final String url, @Nonnull final String bucketID, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ScraperTargetResponse updateScraperTarget(@Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ScraperTargetResponse updateScraperTarget(@Nonnull final String scraperTargetID, @Nonnull final ScraperTargetRequest scraperTargetRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteScraperTarget(@Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteScraperTarget(@Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ScraperTargetResponse cloneScraperTarget(@Nonnull final String clonedName, @Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ScraperTargetResponse cloneScraperTarget(@Nonnull final String clonedName, @Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ScraperTargetResponse findScraperTargetByID(@Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ScraperTargetResponse> findScraperTargets() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ScraperTargetResponse> findScraperTargetsByOrg(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ScraperTargetResponse> findScraperTargetsByOrgId(@Nullable final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final User member, @Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final String memberID, @Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final User member, @Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final String memberID, @Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final User owner, @Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final String ownerID, @Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final User owner, @Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final String ownerID, @Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final ScraperTargetResponse scraperTargetResponse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String scraperTargetID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
