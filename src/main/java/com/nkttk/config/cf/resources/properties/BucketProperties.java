package com.nkttk.config.cf.resources.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.config.cf.resources.properties.notification.NotificationConfiguration;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BucketProperties {
  @JsonProperty("BucketName")
  private String bucketName;
  @JsonProperty("NotificationConfiguration")
  private NotificationConfiguration notificationConfiguration;

  public NotificationConfiguration getNotificationConfiguration() {
    return notificationConfiguration;
  }

  public void setNotificationConfiguration(NotificationConfiguration notificationConfiguration) {
    this.notificationConfiguration = notificationConfiguration;
  }

  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }
}
