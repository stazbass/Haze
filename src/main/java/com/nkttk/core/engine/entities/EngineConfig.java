package com.nkttk.core.engine.entities;

import java.util.List;

/**
 *
 */
public class EngineConfig {
  private List<LambdaConfig> lambdaList;
  private List<S3Config> s3Configs;
  private List<SNSConfig> snsConfigs;
  private List<SQSConfig> sqsConfigs;

  public List<LambdaConfig> getLambdaList() {
    return lambdaList;
  }

  public void setLambdaList(List<LambdaConfig> lambdaList) {
    this.lambdaList = lambdaList;
  }

  public List<S3Config> getS3Configs() {
    return s3Configs;
  }

  public void setS3Configs(List<S3Config> s3Configs) {
    this.s3Configs = s3Configs;
  }

  public List<SNSConfig> getSnsConfigs() {
    return snsConfigs;
  }

  public void setSnsConfigs(List<SNSConfig> snsConfigs) {
    this.snsConfigs = snsConfigs;
  }

  public List<SQSConfig> getSqsConfigs() {
    return sqsConfigs;
  }

  public void setSqsConfigs(List<SQSConfig> sqsConfigs) {
    this.sqsConfigs = sqsConfigs;
  }
}
