package com.nkttk.config.cf.resources.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SNSProperties {
  @JsonProperty("DisplayName")
  private String displayName;
  @JsonProperty("TopicName")
  private String topicName;

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
}
