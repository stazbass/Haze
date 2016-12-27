package com.nkttk.config.cf.resources;

import java.util.Map;

/**
 * Created by Stanislav_Rogovskyi on 12/27/2016.
 */
public class SNSResource {
  private String displayName;
  private String topicName;

  public static SNSResource build(Map params){
    String displayName = (String) params.get("DisplayName");
    String topicName = (String)params.get("TopicName");
    return new SNSResource(displayName, topicName);
  }


  public SNSResource(String displayName, String topicName) {
    this.displayName = displayName;
    this.topicName = topicName;
  }

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
