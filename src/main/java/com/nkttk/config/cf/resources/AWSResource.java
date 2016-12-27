package com.nkttk.config.cf.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "Type")
@JsonSubTypes({
                  @JsonSubTypes.Type(value = BucketResource.class, name = "AWS::S3::Bucket"),
                  @JsonSubTypes.Type(value = LambdaResource.class, name = "AWS::Lambda::Function"),
                  @JsonSubTypes.Type(value = SQSResource.class, name = "AWS::SQS::Queue"),
                  @JsonSubTypes.Type(value = SNSResource.class, name = "AWS::SNS::Topic")})
public class AWSResource {
  @JsonProperty("Type")
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
