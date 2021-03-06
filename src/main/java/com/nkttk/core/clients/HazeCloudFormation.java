package com.nkttk.core.clients;

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
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ContinueUpdateRollbackResult continueUpdateRollback(ContinueUpdateRollbackRequest continueUpdateRollbackRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public CreateChangeSetResult createChangeSet(CreateChangeSetRequest createChangeSetRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public CreateStackResult createStack(CreateStackRequest createStackRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteChangeSetResult deleteChangeSet(DeleteChangeSetRequest deleteChangeSetRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteStackResult deleteStack(DeleteStackRequest deleteStackRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DescribeAccountLimitsResult describeAccountLimits(DescribeAccountLimitsRequest describeAccountLimitsRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DescribeChangeSetResult describeChangeSet(DescribeChangeSetRequest describeChangeSetRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DescribeStackEventsResult describeStackEvents(DescribeStackEventsRequest describeStackEventsRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DescribeStackResourceResult describeStackResource(DescribeStackResourceRequest describeStackResourceRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DescribeStackResourcesResult describeStackResources(DescribeStackResourcesRequest describeStackResourcesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
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
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public EstimateTemplateCostResult estimateTemplateCost(EstimateTemplateCostRequest estimateTemplateCostRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public EstimateTemplateCostResult estimateTemplateCost() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ExecuteChangeSetResult executeChangeSet(ExecuteChangeSetRequest executeChangeSetRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetStackPolicyResult getStackPolicy(GetStackPolicyRequest getStackPolicyRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetTemplateResult getTemplate(GetTemplateRequest getTemplateRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetTemplateSummaryResult getTemplateSummary(GetTemplateSummaryRequest getTemplateSummaryRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetTemplateSummaryResult getTemplateSummary() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListChangeSetsResult listChangeSets(ListChangeSetsRequest listChangeSetsRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListStackResourcesResult listStackResources(ListStackResourcesRequest listStackResourcesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListStacksResult listStacks(ListStacksRequest listStacksRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListStacksResult listStacks() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetStackPolicyResult setStackPolicy(SetStackPolicyRequest setStackPolicyRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SignalResourceResult signalResource(SignalResourceRequest signalResourceRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public UpdateStackResult updateStack(UpdateStackRequest updateStackRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ValidateTemplateResult validateTemplate(ValidateTemplateRequest validateTemplateRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public void shutdown() {

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public AmazonCloudFormationWaiters waiters() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }
}
