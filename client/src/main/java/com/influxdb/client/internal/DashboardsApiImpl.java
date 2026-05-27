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
import com.influxdb.client.DashboardsApi;
import com.influxdb.client.domain.AddResourceMemberRequestBody;
import com.influxdb.client.domain.Cell;
import com.influxdb.client.domain.CellUpdate;
import com.influxdb.client.domain.CreateCell;
import com.influxdb.client.domain.CreateDashboardRequest;
import com.influxdb.client.domain.Dashboard;
import com.influxdb.client.domain.Dashboards;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.LabelMapping;
import com.influxdb.client.domain.LabelResponse;
import com.influxdb.client.domain.LabelsResponse;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.PatchDashboardRequest;
import com.influxdb.client.domain.ResourceMember;
import com.influxdb.client.domain.ResourceMembers;
import com.influxdb.client.domain.ResourceOwner;
import com.influxdb.client.domain.ResourceOwners;
import com.influxdb.client.domain.User;
import com.influxdb.client.domain.View;
import com.influxdb.client.service.DashboardsService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (01/04/2019 10:51)
 */
final class DashboardsApiImpl extends AbstractRestClient implements DashboardsApi {

    private final DashboardsService service;

    DashboardsApiImpl(@Nonnull final DashboardsService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Override
    public Dashboard createDashboard(@Nonnull final String name, @Nullable final String description, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Dashboard createDashboard(@Nonnull final CreateDashboardRequest createDashboardRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Dashboard updateDashboard(@Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteDashboard(@Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteDashboard(@Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Dashboard findDashboardByID(@Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Dashboard> findDashboards() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Dashboard> findDashboardsByOrganization(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Dashboard> findDashboardsByOrgName(@Nullable final String orgName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final User member, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final String memberID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final User member, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final String memberID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final User owner, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final String ownerID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final User owner, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final String ownerID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Cell addCell(@Nonnull final CreateCell createCell, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Cell addCell(@Nonnull final CreateCell createCell, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Dashboard replaceCells(@Nonnull final List<Cell> cells, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Dashboard replaceCells(@Nonnull final List<Cell> cells, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Cell updateCell(@Nonnull final CellUpdate cellUpdate, @Nonnull final String cellID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteCell(@Nonnull final Cell cell, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteCell(@Nonnull final String cellID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public View addCellView(@Nonnull final View view, @Nonnull final Cell cell, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public View addCellView(@Nonnull final View view, @Nonnull final String cellID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public View updateCellView(@Nonnull final View view, @Nonnull final Cell cell, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public View updateCellView(@Nonnull final View view, @Nonnull final String cellID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public View getCellView(@Nonnull final Cell cell, @Nonnull final Dashboard dashboard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public View getCellView(@Nonnull final String cellID, @Nonnull final String dashboardID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
