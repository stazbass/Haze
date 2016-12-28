package com.nkttk.config.cf.resources.properties.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.config.cf.resources.notifications.S3EventType;

/**
 */
public class QueueConfiguration {
  @JsonProperty("Queue")
  private String queue;
  @JsonProperty("Event")
  private S3EventType eventType;

  public String getQueue() {
    return queue;
  }

  public void setQueue(String queue) {
    this.queue = queue;
  }

  public S3EventType getEventType() {
    return eventType;
  }

  public void setEventType(S3EventType eventType) {
    this.eventType = eventType;
  }
}
