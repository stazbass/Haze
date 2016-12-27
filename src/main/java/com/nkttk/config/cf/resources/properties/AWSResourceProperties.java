package com.nkttk.config.cf.resources.properties;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nkttk.config.cf.resources.BucketResource;
import com.nkttk.config.cf.resources.LambdaResource;
import com.nkttk.config.cf.resources.SNSResource;
import com.nkttk.config.cf.resources.SQSResource;

/**
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "Type")
@JsonSubTypes({
                  @JsonSubTypes.Type(value = BucketResource.class, name = "AWS::S3::Bucket"),
                  @JsonSubTypes.Type(value = LambdaResource.class, name = "AWS::Lambda::Function"),
                  @JsonSubTypes.Type(value = SQSResource.class, name = "AWS::SQS::Queue"),
                  @JsonSubTypes.Type(value = SNSResource.class, name = "AWS::SNS::Topic")
              })
public class AWSResourceProperties {

}
