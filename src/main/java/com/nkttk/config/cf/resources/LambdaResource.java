package com.nkttk.config.cf.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.config.cf.resources.properties.LambdaProperties;

/**
 */
public class LambdaResource extends AWSResource{
  @JsonProperty("Properties")
  private LambdaProperties properties;

  public LambdaProperties getProperties() {
    return properties;
  }

  public void setProperties(LambdaProperties properties) {
    this.properties = properties;
  }
}
