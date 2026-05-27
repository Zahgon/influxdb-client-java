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

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.client.TasksApi;
import com.influxdb.client.TasksQuery;
import com.influxdb.client.domain.AddResourceMemberRequestBody;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.LabelMapping;
import com.influxdb.client.domain.LabelResponse;
import com.influxdb.client.domain.LabelsResponse;
import com.influxdb.client.domain.LogEvent;
import com.influxdb.client.domain.Logs;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.ResourceMember;
import com.influxdb.client.domain.ResourceMembers;
import com.influxdb.client.domain.ResourceOwner;
import com.influxdb.client.domain.ResourceOwners;
import com.influxdb.client.domain.Run;
import com.influxdb.client.domain.RunManually;
import com.influxdb.client.domain.Runs;
import com.influxdb.client.domain.Task;
import com.influxdb.client.domain.TaskCreateRequest;
import com.influxdb.client.domain.TaskStatusType;
import com.influxdb.client.domain.TaskUpdateRequest;
import com.influxdb.client.domain.Tasks;
import com.influxdb.client.domain.User;
import com.influxdb.client.service.TasksService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (11/09/2018 07:59)
 */
final class TasksApiImpl extends AbstractRestClient implements TasksApi {

    private static final Logger LOG = Logger.getLogger(TasksApiImpl.class.getName());

    private final TasksService service;

    TasksApiImpl(@Nonnull final TasksService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public Task findTaskByID(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Task> findTasks() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Task> findTasksByUser(@Nonnull final User user) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Task> findTasksByUserID(@Nullable final String userID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Task> findTasksByOrganization(@Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Task> findTasksByOrganizationID(@Nullable final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Task> findTasks(@Nullable final String afterID, @Nullable final String userID, @Nullable final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Task> findTasks(@Nonnull final TasksQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Stream<Task> findTasksStream(@Nonnull final TasksQuery query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task createTask(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task createTask(@Nonnull final TaskCreateRequest taskCreateRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task createTaskCron(@Nonnull final String name, @Nonnull final String flux, @Nonnull final String cron, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task createTaskCron(@Nonnull final String name, @Nonnull final String flux, @Nonnull final String cron, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task createTaskEvery(@Nonnull final String name, @Nonnull final String flux, @Nonnull final String every, @Nonnull final Organization organization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task createTaskEvery(@Nonnull final String name, @Nonnull final String flux, @Nonnull final String every, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task updateTask(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task updateTask(@Nonnull final String taskID, @Nonnull final TaskUpdateRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteTask(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteTask(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task cloneTask(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Task cloneTask(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final User member, @Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final String memberID, @Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final User member, @Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteMember(@Nonnull final String memberID, @Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final User owner, @Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final String ownerID, @Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final User owner, @Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteOwner(@Nonnull final String ownerID, @Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final Task task, @Nullable final OffsetDateTime afterTime, @Nullable final OffsetDateTime beforeTime, @Nullable final Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final String taskID, @Nullable final OffsetDateTime afterTime, @Nullable final OffsetDateTime beforeTime, @Nullable final Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Run getRun(@Nonnull final Run run) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Run getRun(@Nonnull final String taskID, @Nonnull final String runID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<LogEvent> getRunLogs(@Nonnull final Run run) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<LogEvent> getRunLogs(@Nonnull final String taskID, @Nonnull final String runID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Run runManually(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Run runManually(@Nonnull final String taskId, @Nonnull final RunManually runManually) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Run retryRun(@Nonnull final Run run) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public Run retryRun(@Nonnull final String taskID, @Nonnull final String runID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancelRun(@Nonnull final Run run) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancelRun(@Nonnull final String taskID, @Nonnull final String runID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<LogEvent> getLogs(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<LogEvent> getLogs(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final Task task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String taskID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private Task createTask(@Nonnull final String name, @Nonnull final String flux, @Nullable final String every, @Nullable final String cron, @Nonnull final String orgID) {
        Arguments.checkNonEmpty(name, "name of the task");
        Arguments.checkNotNull(flux, "Flux script to run");
        Arguments.checkNonEmpty(orgID, "Organization ID");
        Arguments.checkDurationNotRequired(every, "Task.every");
        Task task = new Task();
        task.setName(name);
        task.setOrgID(orgID);
        task.setStatus(TaskStatusType.ACTIVE);
        task.setFlux(flux);
        String repetition = "";
        if (every != null) {
            repetition += "every: ";
            repetition += every;
        }
        if (cron != null) {
            repetition += "cron: ";
            repetition += "\"" + cron + "\"";
        }
        String fluxWithOptions = String.format("%s\n\noption task = {name: \"%s\", %s}", flux, name, repetition);
        task.setFlux(fluxWithOptions);
        return task;
    }
}
