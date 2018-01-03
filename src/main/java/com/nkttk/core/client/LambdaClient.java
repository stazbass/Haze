package com.nkttk.core.client;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.*;
import com.nkttk.core.engine.ComponentStack;
import com.nkttk.core.engine.component.lambda.LambdaContext;
import org.apache.http.HttpStatus;

import java.nio.ByteBuffer;

public class LambdaClient<I, O> implements AWSLambda {
    private LambdaContext context;
    private ComponentStack componentStack;

    public LambdaClient(ComponentStack componentStack, LambdaContext context) {
        this.componentStack = componentStack;
        this.context = context;
    }

    @Override
    public void setEndpoint(String endpoint) {

    }

    @Override
    public void setRegion(Region region) {

    }

    @Override
    public AddPermissionResult addPermission(AddPermissionRequest addPermissionRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public CreateAliasResult createAlias(CreateAliasRequest createAliasRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public CreateEventSourceMappingResult createEventSourceMapping(CreateEventSourceMappingRequest
                                                                           createEventSourceMappingRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public CreateFunctionResult createFunction(CreateFunctionRequest createFunctionRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DeleteAliasResult deleteAlias(DeleteAliasRequest deleteAliasRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DeleteEventSourceMappingResult deleteEventSourceMapping(DeleteEventSourceMappingRequest
                                                                           deleteEventSourceMappingRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DeleteFunctionResult deleteFunction(DeleteFunctionRequest deleteFunctionRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public GetAliasResult getAlias(GetAliasRequest getAliasRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public GetEventSourceMappingResult getEventSourceMapping(GetEventSourceMappingRequest getEventSourceMappingRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public GetFunctionResult getFunction(GetFunctionRequest getFunctionRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public GetFunctionConfigurationResult getFunctionConfiguration(GetFunctionConfigurationRequest
                                                                           getFunctionConfigurationRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public GetPolicyResult getPolicy(GetPolicyRequest getPolicyRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public InvokeResult invoke(InvokeRequest invokeRequest) {
        ByteBuffer resultPayload = null;
        InvokeResult result = new InvokeResult();
        try {
            resultPayload = componentStack.runLambda(invokeRequest.getFunctionName(), invokeRequest.getPayload());
            result.setPayload(resultPayload);
            result.setStatusCode(HttpStatus.SC_ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            result.setPayload(ByteBuffer.wrap(e.getMessage().getBytes()));
            result.setFunctionError(e.getMessage());
            result.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @Override
    public InvokeAsyncResult invokeAsync(InvokeAsyncRequest invokeAsyncRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListAliasesResult listAliases(ListAliasesRequest listAliasesRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListEventSourceMappingsResult listEventSourceMappings(ListEventSourceMappingsRequest listEventSourceMappingsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListEventSourceMappingsResult listEventSourceMappings() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListFunctionsResult listFunctions(ListFunctionsRequest listFunctionsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListFunctionsResult listFunctions() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListVersionsByFunctionResult listVersionsByFunction(ListVersionsByFunctionRequest listVersionsByFunctionRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public PublishVersionResult publishVersion(PublishVersionRequest publishVersionRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public RemovePermissionResult removePermission(RemovePermissionRequest removePermissionRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public UpdateAliasResult updateAlias(UpdateAliasRequest updateAliasRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public UpdateEventSourceMappingResult updateEventSourceMapping(UpdateEventSourceMappingRequest
                                                                           updateEventSourceMappingRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public UpdateFunctionCodeResult updateFunctionCode(UpdateFunctionCodeRequest updateFunctionCodeRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public UpdateFunctionConfigurationResult updateFunctionConfiguration(UpdateFunctionConfigurationRequest updateFunctionConfigurationRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public void shutdown() {

    }

    @Override
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }
}
