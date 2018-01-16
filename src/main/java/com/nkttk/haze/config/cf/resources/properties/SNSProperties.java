package com.nkttk.haze.config.cf.resources.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.haze.config.cf.resources.properties.subscription.SNSSubscription;

import java.util.List;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SNSProperties {
    @JsonProperty("DisplayName")
    private String displayName;
    @JsonProperty("TopicName")
    private String topicName;
    @JsonProperty("Subscription")
    private List<SNSSubscription> subscriptions;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<SNSSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SNSSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
