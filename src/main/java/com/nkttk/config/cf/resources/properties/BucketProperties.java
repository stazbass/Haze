package com.nkttk.config.cf.resources.properties;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class BucketProperties {
  @JsonProperty("BucketName")
  private String bucketName;
  @JsonProperty("NotificationConfiguration")
  private String notificationConfiguration;

  public String getNotificationConfiguration() {
    return notificationConfiguration;
  }

  public void setNotificationConfiguration(String notificationConfiguration) {
    this.notificationConfiguration = notificationConfiguration;
  }

  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }
}
