package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class LambdaContext implements Context {
  private String functionName;

  public LambdaContext(String functionName) {
    this.functionName = functionName;
  }

  @Override
  public String getAwsRequestId() {
    return null;
  }

  @Override
  public String getLogGroupName() {
    return null;
  }

  @Override
  public String getLogStreamName() {
    return null;
  }

  @Override
  public String getFunctionName() {
    return functionName;
  }

  @Override
  public String getFunctionVersion() {
    return "1";
  }

  @Override
  public String getInvokedFunctionArn() {
    return null;
  }

  @Override
  public CognitoIdentity getIdentity() {
    return null;
  }

  @Override
  public ClientContext getClientContext() {
    return null;
  }

  @Override
  public int getRemainingTimeInMillis() {
    return 0;
  }

  @Override
  public int getMemoryLimitInMB() {
    return 256;
  }

  @Override
  public LambdaLogger getLogger() {
    return null;
  }
}
