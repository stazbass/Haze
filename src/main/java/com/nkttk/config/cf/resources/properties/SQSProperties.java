package com.nkttk.config.cf.resources.properties;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class SQSProperties {
  @JsonProperty("QueueName")
  private String queueName;

  public String getQueueName() {
    return queueName;
  }

  public void setQueueName(String queueName) {
    this.queueName = queueName;
  }
}
