package com.nkttk.config.cf.resources.properties.subscription;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 */
public enum SubscriptionProtocol {
  SQS("sqs");
  private String name;

  SubscriptionProtocol(String name){
    this.name = name;
  }

  @JsonCreator
  public SubscriptionProtocol fromName(String name){
    SubscriptionProtocol [] types = SubscriptionProtocol.values();
    for(int i = 0; i < types.length; i++){
      if(name.equals(types[i]))return types[i];
    }
    throw new RuntimeException("Unknown resource type " + name);
  }

  @JsonValue
  public String toJsonValue(){
    return name;
  }
}
