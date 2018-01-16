package com.nkttk.haze.config.cf.resources.properties.notification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.haze.config.cf.resources.properties.notification.configuration.CloudFunctionConfiguration;
import com.nkttk.haze.config.cf.resources.properties.notification.configuration.QueueConfiguration;
import com.nkttk.haze.config.cf.resources.properties.notification.configuration.TopicConfiguration;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationConfiguration {
    @JsonProperty("LambdaConfiguration")
    private CloudFunctionConfiguration lambdaConfigurations;
    @JsonProperty("QueueConfiguration")
    private QueueConfiguration queueConfiguration;
    @JsonProperty("TopicConfiguration")
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
