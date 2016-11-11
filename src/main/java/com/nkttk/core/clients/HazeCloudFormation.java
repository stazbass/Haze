package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.*;
import com.nkttk.core.components.ComponentIdentifier;
import com.nkttk.core.engine.AWSEngine;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class HazeCloudFormation implements AmazonCloudFormation {
  AWSEngine engine;

  public HazeCloudFormation(AWSEngine engine){
    this.engine = engine;
  }

  @Override
  public void setEndpoint(String s) throws IllegalArgumentException {

  }

  @Override
  public void setRegion(Region region) throws IllegalArgumentException {

  }

  @Override
  public GetTemplateSummaryResult getTemplateSummary(GetTemplateSummaryRequest getTemplateSummaryRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ValidateTemplateResult validateTemplate(ValidateTemplateRequest validateTemplateRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  private Output buildOutput(String key, String value){
    Output result = new Output();
    result.setOutputKey(key);
    result.setOutputValue(value);
    return result;
  }

  @Override
  public DescribeStacksResult describeStacks(DescribeStacksRequest describeStacksRequest) throws AmazonServiceException, AmazonClientException {
    DescribeStacksResult result = new DescribeStacksResult();
    List<Stack> stacks = new LinkedList<>();
    Stack stack = new Stack();
    List<ComponentIdentifier> ids = engine.getAllIdentifiers();
    List<Output> outputs = ids.stream().map(id->buildOutput(id.getKey(), id.getValue())).collect(Collectors.toList());

    stack.setOutputs(outputs);
    result.setStacks(stacks);
    return result;
  }

  @Override
  public GetTemplateResult getTemplate(GetTemplateRequest getTemplateRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public GetStackPolicyResult getStackPolicy(GetStackPolicyRequest getStackPolicyRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListStacksResult listStacks(ListStacksRequest listStacksRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setStackPolicy(SetStackPolicyRequest setStackPolicyRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public CreateStackResult createStack(CreateStackRequest createStackRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public EstimateTemplateCostResult estimateTemplateCost(EstimateTemplateCostRequest estimateTemplateCostRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeStackEventsResult describeStackEvents(DescribeStackEventsRequest describeStackEventsRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeStackResourceResult describeStackResource(DescribeStackResourceRequest describeStackResourceRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void signalResource(SignalResourceRequest signalResourceRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void cancelUpdateStack(CancelUpdateStackRequest cancelUpdateStackRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public UpdateStackResult updateStack(UpdateStackRequest updateStackRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeStackResourcesResult describeStackResources(DescribeStackResourcesRequest describeStackResourcesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListStackResourcesResult listStackResources(ListStackResourcesRequest listStackResourcesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void deleteStack(DeleteStackRequest deleteStackRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public GetTemplateSummaryResult getTemplateSummary() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeStacksResult describeStacks() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListStacksResult listStacks() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public EstimateTemplateCostResult estimateTemplateCost() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void shutdown() {

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
    return null;
  }
}
