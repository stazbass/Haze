package com.nkttk.haze.config.cf.resources.properties.notification.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.haze.config.cf.resources.notifications.S3EventType;
import com.nkttk.haze.config.cf.resources.properties.notification.filter.S3KeyFilter;

import java.util.Map;

/**
 */
public class CloudFunctionConfiguration {
    @JsonProperty("Function")
    private Map function;
    @JsonProperty("Filter")
    private S3KeyFilter filter;
    @JsonProperty("S3Notification")
    private S3EventType eventType;

    public Map getFunction() {
        return function;
    }

    public void setFunction(Map function) {
        this.function = function;
    }

    public S3KeyFilter getFilter() {
        return filter;
    }

    public void setFilter(S3KeyFilter filter) {
        this.filter = filter;
    }

    public S3EventType getEventType() {
        return eventType;
    }

    public void setEventType(S3EventType eventType) {
        this.eventType = eventType;
    }
}
