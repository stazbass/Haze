package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.*;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.nkttk.core.components.lambda.LambdaContext;
import com.nkttk.core.engine.AWSEngine;
import com.nkttk.json.JsonMaster;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.util.function.Supplier;

public class LambdaClient<I,O> implements AWSLambda {
  private Supplier<RequestHandler<I, O>> lambdaFactoryFunction;
  private LambdaContext context;
  private AWSEngine awsEngine;

  public LambdaClient(AWSEngine awsEngine, LambdaContext context){ // TODO move to aws client
    this.awsEngine = awsEngine;
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
    return null;
  }

  @Override
  public CreateAliasResult createAlias(CreateAliasRequest createAliasRequest) {
    return null;
  }

  @Override
  public CreateEventSourceMappingResult createEventSourceMapping(CreateEventSourceMappingRequest
                                                                       createEventSourceMappingRequest) {
    return null;
  }

  @Override
  public CreateFunctionResult createFunction(CreateFunctionRequest createFunctionRequest) {
    return null;
  }

  @Override
  public DeleteAliasResult deleteAlias(DeleteAliasRequest deleteAliasRequest) {
    return null;
  }

  @Override
  public DeleteEventSourceMappingResult deleteEventSourceMapping(DeleteEventSourceMappingRequest
                                                                       deleteEventSourceMappingRequest) {
    return null;
  }

  @Override
  public DeleteFunctionResult deleteFunction(DeleteFunctionRequest deleteFunctionRequest) {
    return null;
  }

  @Override
  public GetAliasResult getAlias(GetAliasRequest getAliasRequest) {
    return null;
  }

  @Override
  public GetEventSourceMappingResult getEventSourceMapping(GetEventSourceMappingRequest getEventSourceMappingRequest) {
    return null;
  }

  @Override
  public GetFunctionResult getFunction(GetFunctionRequest getFunctionRequest) {
    return null;
  }

  @Override
  public GetFunctionConfigurationResult getFunctionConfiguration(GetFunctionConfigurationRequest
                                                                       getFunctionConfigurationRequest) {
    return null;
  }

  @Override
  public GetPolicyResult getPolicy(GetPolicyRequest getPolicyRequest) {
    return null;
  }

  @Override
  public InvokeResult invoke(InvokeRequest invokeRequest) {
    ByteBuffer resultPayload = null;
    InvokeResult result = new InvokeResult();
    try {
      resultPayload = awsEngine.runLambda(invokeRequest.getFunctionName(), invokeRequest.getPayload());
      result.setPayload(resultPayload);
      result.setStatusCode(HttpStatus.SC_ACCEPTED);
    } catch (Exception e){
      e.printStackTrace();
      result.setPayload(ByteBuffer.wrap(e.getMessage().getBytes()));
      result.setFunctionError(e.getMessage());
      result.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
    return result;
  }

  @Override
  public InvokeAsyncResult invokeAsync(InvokeAsyncRequest invokeAsyncRequest) {
    return null;
  }

  @Override
  public ListAliasesResult listAliases(ListAliasesRequest listAliasesRequest) {
    return null;
  }

  @Override
  public ListEventSourceMappingsResult listEventSourceMappings(ListEventSourceMappingsRequest listEventSourceMappingsRequest) {
    return null;
  }

  @Override
  public ListEventSourceMappingsResult listEventSourceMappings() {
    return null;
  }

  @Override
  public ListFunctionsResult listFunctions(ListFunctionsRequest listFunctionsRequest) {
    return null;
  }

  @Override
  public ListFunctionsResult listFunctions() {
    return null;
  }

  @Override
  public ListVersionsByFunctionResult listVersionsByFunction(ListVersionsByFunctionRequest listVersionsByFunctionRequest) {
    return null;
  }

  @Override
  public PublishVersionResult publishVersion(PublishVersionRequest publishVersionRequest) {
    return null;
  }

  @Override
  public RemovePermissionResult removePermission(RemovePermissionRequest removePermissionRequest) {
    return null;
  }

  @Override
  public UpdateAliasResult updateAlias(UpdateAliasRequest updateAliasRequest) {
    return null;
  }

  @Override
  public UpdateEventSourceMappingResult updateEventSourceMapping(UpdateEventSourceMappingRequest
                                                                       updateEventSourceMappingRequest) {
    return null;
  }

  @Override
  public UpdateFunctionCodeResult updateFunctionCode(UpdateFunctionCodeRequest updateFunctionCodeRequest) {
    return null;
  }

  @Override
  public UpdateFunctionConfigurationResult updateFunctionConfiguration(UpdateFunctionConfigurationRequest updateFunctionConfigurationRequest) {
    return null;
  }

  @Override
  public void shutdown() {

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
    return null;
  }
}
