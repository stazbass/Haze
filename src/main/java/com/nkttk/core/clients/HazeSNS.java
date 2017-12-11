package com.nkttk.core.clients;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.*;
import com.nkttk.core.engine.ComponentContainer;

import java.util.List;

/**
 *
 */
public class HazeSNS implements AmazonSNS {
  private ComponentContainer engine;

  public HazeSNS(ComponentContainer engine){
    this.engine = engine;
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
  public AddPermissionResult addPermission(String topicArn, String label, List<String> aWSAccountIds, List<String>
      actionNames) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public CheckIfPhoneNumberIsOptedOutResult checkIfPhoneNumberIsOptedOut(CheckIfPhoneNumberIsOptedOutRequest
                                                                               checkIfPhoneNumberIsOptedOutRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(String topicArn, String token, String
      authenticateOnUnsubscribe) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(String topicArn, String token) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public CreatePlatformApplicationResult createPlatformApplication(CreatePlatformApplicationRequest
                                                                         createPlatformApplicationRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public CreatePlatformEndpointResult createPlatformEndpoint(CreatePlatformEndpointRequest
                                                                   createPlatformEndpointRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public CreateTopicResult createTopic(CreateTopicRequest createTopicRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public CreateTopicResult createTopic(String name) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteEndpointResult deleteEndpoint(DeleteEndpointRequest deleteEndpointRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeletePlatformApplicationResult deletePlatformApplication(DeletePlatformApplicationRequest deletePlatformApplicationRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteTopicResult deleteTopic(DeleteTopicRequest deleteTopicRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteTopicResult deleteTopic(String topicArn) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetEndpointAttributesResult getEndpointAttributes(GetEndpointAttributesRequest getEndpointAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetPlatformApplicationAttributesResult getPlatformApplicationAttributes
      (GetPlatformApplicationAttributesRequest getPlatformApplicationAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetSMSAttributesResult getSMSAttributes(GetSMSAttributesRequest getSMSAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(String subscriptionArn) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(GetTopicAttributesRequest getTopicAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(String topicArn) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListEndpointsByPlatformApplicationResult listEndpointsByPlatformApplication(ListEndpointsByPlatformApplicationRequest listEndpointsByPlatformApplicationRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListPhoneNumbersOptedOutResult listPhoneNumbersOptedOut(ListPhoneNumbersOptedOutRequest listPhoneNumbersOptedOutRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications(ListPlatformApplicationsRequest
                                                                       listPlatformApplicationsRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListSubscriptionsResult listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListSubscriptionsResult listSubscriptions() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListSubscriptionsResult listSubscriptions(String nextToken) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String topicArn) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String topicArn, String nextToken) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListTopicsResult listTopics(ListTopicsRequest listTopicsRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListTopicsResult listTopics() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListTopicsResult listTopics(String nextToken) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public OptInPhoneNumberResult optInPhoneNumber(OptInPhoneNumberRequest optInPhoneNumberRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public PublishResult publish(PublishRequest publishRequest) {
    engine.publishSNSMessage(publishRequest.getTopicArn(), publishRequest.getMessage());
    return new PublishResult();
  }

  @Override
  public PublishResult publish(String topicArn, String message) {
    engine.publishSNSMessage(topicArn, message);
    return new PublishResult();
  }

  @Override
  public PublishResult publish(String topicArn, String message, String subject) {
    engine.publishSNSMessage(topicArn, message);
    return new PublishResult();
  }

  @Override
  public RemovePermissionResult removePermission(RemovePermissionRequest removePermissionRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public RemovePermissionResult removePermission(String topicArn, String label) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetEndpointAttributesResult setEndpointAttributes(SetEndpointAttributesRequest setEndpointAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetPlatformApplicationAttributesResult setPlatformApplicationAttributes
      (SetPlatformApplicationAttributesRequest setPlatformApplicationAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetSMSAttributesResult setSMSAttributes(SetSMSAttributesRequest setSMSAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetSubscriptionAttributesResult setSubscriptionAttributes(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetSubscriptionAttributesResult setSubscriptionAttributes(String subscriptionArn, String attributeName,
                                                                   String attributeValue) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetTopicAttributesResult setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetTopicAttributesResult setTopicAttributes(String topicArn, String attributeName, String attributeValue) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SubscribeResult subscribe(SubscribeRequest subscribeRequest) {
     throw new RuntimeException("NOT IMPLEMENTED");
 }

  @Override
  public SubscribeResult subscribe(String topicArn, String protocol, String endpoint) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public UnsubscribeResult unsubscribe(UnsubscribeRequest unsubscribeRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public UnsubscribeResult unsubscribe(String subscriptionArn) {
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
