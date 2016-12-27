package com.nkttk.config.cf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudFormationConfig {
  @JsonProperty("Resources")
  private Map<String, CloudFormationResource> resources;

  public CloudFormationConfig() {
  }

  public CloudFormationConfig(Map<String, CloudFormationResource> resources) {
    this.resources = resources;
  }

  public Map<String, CloudFormationResource> getResources() {
    return resources;
  }

  public void setResources(Map<String, CloudFormationResource> resources) {
    this.resources = resources;
  }

  public List<CloudFormationResource> getResources(ResourceType type){
    List<CloudFormationResource> result = new LinkedList<>();
    for(String key : resources.keySet()){
      if(resources.get(key).getType().equals(type)){
        result.add(resources.get(key));
      }
    }
    return result;
  }
}
