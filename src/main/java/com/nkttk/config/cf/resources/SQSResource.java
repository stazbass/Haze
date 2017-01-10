package com.nkttk.config.cf.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.config.cf.resources.properties.SQSProperties;

/**
 */
public class SQSResource extends AWSResource {
  @JsonProperty("Properties")
  private SQSProperties properties;

  public SQSProperties getProperties() {
    return properties;
  }

  public void setProperties(SQSProperties properties) {
    this.properties = properties;
  }
}
