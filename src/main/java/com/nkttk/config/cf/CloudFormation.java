package com.nkttk.config.cf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudFormation {
  @JsonProperty("Resources")
  private Map<String, CloudFormationResource> resources;

  public CloudFormation() {
  }

  public CloudFormation(Map<String, CloudFormationResource> resources) {
    this.resources = resources;
  }

  public Map<String, CloudFormationResource> getResources() {
    return resources;
  }

  public void setResources(Map<String, CloudFormationResource> resources) {
    this.resources = resources;
  }
}
