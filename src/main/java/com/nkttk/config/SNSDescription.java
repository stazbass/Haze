package com.nkttk.config;

/**
 *
 */
public class SNSDescription {
  private String topic;

  public SNSDescription(String topic) {

    this.topic = topic;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  @Override
  public String toString() {
    return "SNSDescription{" +
           "topic='" + topic + '\'' +
           '}';
  }
}
