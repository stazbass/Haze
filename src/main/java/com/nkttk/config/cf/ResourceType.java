package com.nkttk.config.cf;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 */
public enum ResourceType {
  SQS("AWS::SQS::Queue"),SNS("AWS::SNS::Topic"),BUCKET("AWS::S3::Bucket"), ALARM("AWS::CloudWatch::Alarm"),
  LAMBDA("AWS::Lambda::Function"), ROLE("AWS::IAM::Role"), IAM_POLICY("AWS::IAM::Policy"), LAMBDA_VERSION("AWS::Lambda::Version"),
  EVENT_RULE("AWS::Events::Rule"), LAMBDA_PERMISSION("AWS::Lambda::Permission"), QUEUE_POLICY("AWS::SQS::QueuePolicy"),
  IAM_MANAGED_POLICY("AWS::IAM::ManagedPolicy");

  private String name;

  ResourceType(String name){
    this.name = name;
  }

  @JsonCreator
  public ResourceType fromName(String name){
    ResourceType [] types = ResourceType.values();
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
