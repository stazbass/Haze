package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.*;
import com.amazonaws.services.cloudformation.waiters.AmazonCloudFormationWaiters;
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
  public void setEndpoint(String endpoint) {

  }

  @Override
  public void setRegion(Region region) {

  }

  @Override
  public CancelUpdateStackResult cancelUpdateStack(CancelUpdateStackRequest cancelUpdateStackRequest) {
    return null;
  }

  @Override
  public ContinueUpdateRollbackResult continueUpdateRollback(ContinueUpdateRollbackRequest continueUpdateRollbackRequest) {
    return null;
  }

  @Override
  public CreateChangeSetResult createChangeSet(CreateChangeSetRequest createChangeSetRequest) {
    return null;
  }

  @Override
  public CreateStackResult createStack(CreateStackRequest createStackRequest) {
    return null;
  }

  @Override
  public DeleteChangeSetResult deleteChangeSet(DeleteChangeSetRequest deleteChangeSetRequest) {
    return null;
  }

  @Override
  public DeleteStackResult deleteStack(DeleteStackRequest deleteStackRequest) {
    return null;
  }

  @Override
  public DescribeAccountLimitsResult describeAccountLimits(DescribeAccountLimitsRequest describeAccountLimitsRequest) {
    return null;
  }

  @Override
  public DescribeChangeSetResult describeChangeSet(DescribeChangeSetRequest describeChangeSetRequest) {
    return null;
  }

  @Override
  public DescribeStackEventsResult describeStackEvents(DescribeStackEventsRequest describeStackEventsRequest) {
    return null;
  }

  @Override
  public DescribeStackResourceResult describeStackResource(DescribeStackResourceRequest describeStackResourceRequest) {
    return null;
  }

  @Override
  public DescribeStackResourcesResult describeStackResources(DescribeStackResourcesRequest describeStackResourcesRequest) {
    return null;
  }
  private Output buildOutput(String key, String value){
    Output result = new Output();
    result.setOutputKey(key);
    result.setOutputValue(value);
    return result;
  }

  @Override
  public DescribeStacksResult describeStacks(DescribeStacksRequest describeStacksRequest) {
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
  public DescribeStacksResult describeStacks() {
    return null;
  }

  @Override
  public EstimateTemplateCostResult estimateTemplateCost(EstimateTemplateCostRequest estimateTemplateCostRequest) {
    return null;
  }

  @Override
  public EstimateTemplateCostResult estimateTemplateCost() {
    return null;
  }

  @Override
  public ExecuteChangeSetResult executeChangeSet(ExecuteChangeSetRequest executeChangeSetRequest) {
    return null;
  }

  @Override
  public GetStackPolicyResult getStackPolicy(GetStackPolicyRequest getStackPolicyRequest) {
    return null;
  }

  @Override
  public GetTemplateResult getTemplate(GetTemplateRequest getTemplateRequest) {
    return null;
  }

  @Override
  public GetTemplateSummaryResult getTemplateSummary(GetTemplateSummaryRequest getTemplateSummaryRequest) {
    return null;
  }

  @Override
  public GetTemplateSummaryResult getTemplateSummary() {
    return null;
  }

  @Override
  public ListChangeSetsResult listChangeSets(ListChangeSetsRequest listChangeSetsRequest) {
    return null;
  }

  @Override
  public ListStackResourcesResult listStackResources(ListStackResourcesRequest listStackResourcesRequest) {
    return null;
  }

  @Override
  public ListStacksResult listStacks(ListStacksRequest listStacksRequest) {
    return null;
  }

  @Override
  public ListStacksResult listStacks() {
    return null;
  }

  @Override
  public SetStackPolicyResult setStackPolicy(SetStackPolicyRequest setStackPolicyRequest) {
    return null;
  }

  @Override
  public SignalResourceResult signalResource(SignalResourceRequest signalResourceRequest) {
    return null;
  }

  @Override
  public UpdateStackResult updateStack(UpdateStackRequest updateStackRequest) {
    return null;
  }

  @Override
  public ValidateTemplateResult validateTemplate(ValidateTemplateRequest validateTemplateRequest) {
    return null;
  }

  @Override
  public void shutdown() {

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
    return null;
  }

  @Override
  public AmazonCloudFormationWaiters waiters() {
    return null;
  }
}
