package com.nkttk.config.cf.resources.properties.notification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationConfiguration {
  @JsonProperty("QueueConfigurations")
  private CloudFunctionConfiguration lambdaConfigurations;
  @JsonProperty("LambdaConfigurations")
  private QueueConfiguration queueConfiguration;
  @JsonProperty("TopicConfigurations")
  private TopicConfiguration topicConfigurations;

  public CloudFunctionConfiguration getLambdaConfigurations() {
    return lambdaConfigurations;
  }

  public void setLambdaConfigurations(CloudFunctionConfiguration lambdaConfigurations) {
    this.lambdaConfigurations = lambdaConfigurations;
  }

  public QueueConfiguration getQueueConfiguration() {
    return queueConfiguration;
  }

  public void setQueueConfiguration(QueueConfiguration queueConfiguration) {
    this.queueConfiguration = queueConfiguration;
  }

  public TopicConfiguration getTopicConfigurations() {
    return topicConfigurations;
  }

  public void setTopicConfigurations(TopicConfiguration topicConfigurations) {
    this.topicConfigurations = topicConfigurations;
  }
}
