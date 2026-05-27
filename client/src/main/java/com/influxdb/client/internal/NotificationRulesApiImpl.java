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

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import com.influxdb.client.FindOptions;
import com.influxdb.client.NotificationRulesApi;
import com.influxdb.client.domain.HTTPNotificationEndpoint;
import com.influxdb.client.domain.HTTPNotificationRule;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.LabelMapping;
import com.influxdb.client.domain.LabelResponse;
import com.influxdb.client.domain.LabelsResponse;
import com.influxdb.client.domain.NotificationEndpoint;
import com.influxdb.client.domain.NotificationRule;
import com.influxdb.client.domain.NotificationRuleUpdate;
import com.influxdb.client.domain.NotificationRules;
import com.influxdb.client.domain.PagerDutyNotificationEndpoint;
import com.influxdb.client.domain.PagerDutyNotificationRule;
import com.influxdb.client.domain.RuleStatusLevel;
import com.influxdb.client.domain.SlackNotificationEndpoint;
import com.influxdb.client.domain.SlackNotificationRule;
import com.influxdb.client.domain.StatusRule;
import com.influxdb.client.domain.TagRule;
import com.influxdb.client.domain.TaskStatusType;
import com.influxdb.client.service.NotificationRulesService;
import com.influxdb.internal.AbstractRestClient;
import com.influxdb.utils.Arguments;
import retrofit2.Call;

/**
 * @author Jakub Bednar (23/09/2019 10:55)
 */
final class NotificationRulesApiImpl extends AbstractRestClient implements NotificationRulesApi {

    private final NotificationRulesService service;

    NotificationRulesApiImpl(@Nonnull final NotificationRulesService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public SlackNotificationRule createSlackRule(@Nonnull final String name, @Nonnull final String every, @Nonnull final String messageTemplate, @Nonnull final RuleStatusLevel status, @Nonnull final SlackNotificationEndpoint endpoint, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public SlackNotificationRule createSlackRule(@Nonnull final String name, @Nonnull final String every, @Nonnull final String messageTemplate, @Nonnull final RuleStatusLevel status, @Nonnull final List<TagRule> tagRules, @Nonnull final SlackNotificationEndpoint endpoint, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public PagerDutyNotificationRule createPagerDutyRule(@Nonnull final String name, @Nonnull final String every, @Nonnull final String messageTemplate, @Nonnull final RuleStatusLevel status, @Nonnull final List<TagRule> tagRules, @Nonnull final PagerDutyNotificationEndpoint endpoint, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public HTTPNotificationRule createHTTPRule(@Nonnull final String name, @Nonnull final String every, @Nonnull final RuleStatusLevel status, @Nonnull final List<TagRule> tagRules, @Nonnull final HTTPNotificationEndpoint endpoint, @Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Nonnull
    public NotificationRule createRule(@Nonnull final NotificationRule rule) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationRule updateNotificationRule(@Nonnull final NotificationRule notificationRule) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationRule updateNotificationRule(@Nonnull final String ruleID, @Nonnull final NotificationRuleUpdate update) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteNotificationRule(@Nonnull final NotificationRule notificationRule) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteNotificationRule(@Nonnull final String ruleID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationRule findNotificationRuleByID(@Nonnull final String ruleID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<NotificationRule> findNotificationRules(@Nonnull final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public NotificationRules findNotificationRules(@Nonnull final String orgID, @Nonnull final FindOptions findOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final NotificationRule notificationRule) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String ruleID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final NotificationRule notificationRule) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String ruleID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final NotificationRule notificationRule) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String ruleID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private NotificationRule createRule(@Nonnull final String name, @Nonnull final String every, @Nonnull final RuleStatusLevel status, @Nonnull final List<TagRule> tagRules, @Nonnull final NotificationEndpoint notificationEndpoint, @Nonnull final String orgID, @Nonnull final NotificationRule rule) {
        Arguments.checkNotNull(rule, "rule");
        rule.setName(name);
        rule.setEvery(every);
        rule.setOrgID(orgID);
        rule.setTagRules(tagRules);
        rule.addStatusRulesItem(new StatusRule().currentLevel(status));
        rule.setEndpointID(notificationEndpoint.getId());
        rule.setStatus(TaskStatusType.ACTIVE);
        return createRule(rule);
    }
}
