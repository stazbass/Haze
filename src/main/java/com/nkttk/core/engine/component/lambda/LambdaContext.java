package com.nkttk.core.engine.component.lambda;

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
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public String getLogGroupName() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public String getLogStreamName() {
        throw new RuntimeException("NOT IMPLEMENTED");
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
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public CognitoIdentity getIdentity() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ClientContext getClientContext() {
        throw new RuntimeException("NOT IMPLEMENTED");
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
        throw new RuntimeException("NOT IMPLEMENTED");
    }
}
