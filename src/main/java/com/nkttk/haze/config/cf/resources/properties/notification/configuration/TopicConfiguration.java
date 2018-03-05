package com.nkttk.haze.config.cf.resources.properties.notification.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.haze.config.cf.resources.notifications.S3EventType;

/**
 */
public class TopicConfiguration {
    @JsonProperty("Topic")
    private String topic;
    @JsonProperty("S3Notification")
    private S3EventType eventType;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public S3EventType getEventType() {
        return eventType;
    }

    public void setEventType(S3EventType eventType) {
        this.eventType = eventType;
    }
}
