package com.nkttk.config.cf.resources.properties.notification.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.config.cf.resources.notifications.S3EventType;
import com.nkttk.config.cf.resources.properties.notification.filter.S3KeyFilter;

import java.util.Map;

/**
 */
public class CloudFunctionConfiguration {
  @JsonProperty("Function")
  private Map function;
  @JsonProperty("Filter")
  private S3KeyFilter filter;
  @JsonProperty("Event")
  private S3EventType eventType;

}
