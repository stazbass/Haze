package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.*;
import com.nkttk.core.engine.AWSEngine;

import java.util.List;

/**
 *
 */
public class HazeSNS implements AmazonSNS {
  private AWSEngine engine;

  public HazeSNS(AWSEngine engine){
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
    return null;
  }

  @Override
  public AddPermissionResult addPermission(String topicArn, String label, List<String> aWSAccountIds, List<String>
      actionNames) {
    return null;
  }

  @Override
  public CheckIfPhoneNumberIsOptedOutResult checkIfPhoneNumberIsOptedOut(CheckIfPhoneNumberIsOptedOutRequest
                                                                               checkIfPhoneNumberIsOptedOutRequest) {
    return null;
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
    return null;
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(String topicArn, String token, String
      authenticateOnUnsubscribe) {
    return null;
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(String topicArn, String token) {
    return null;
  }

  @Override
  public CreatePlatformApplicationResult createPlatformApplication(CreatePlatformApplicationRequest
                                                                         createPlatformApplicationRequest) {
    return null;
  }

  @Override
  public CreatePlatformEndpointResult createPlatformEndpoint(CreatePlatformEndpointRequest
                                                                   createPlatformEndpointRequest) {
    return null;
  }

  @Override
  public CreateTopicResult createTopic(CreateTopicRequest createTopicRequest) {
    return null;
  }

  @Override
  public CreateTopicResult createTopic(String name) {
    return null;
  }

  @Override
  public DeleteEndpointResult deleteEndpoint(DeleteEndpointRequest deleteEndpointRequest) {
    return null;
  }

  @Override
  public DeletePlatformApplicationResult deletePlatformApplication(DeletePlatformApplicationRequest deletePlatformApplicationRequest) {
    return null;
  }

  @Override
  public DeleteTopicResult deleteTopic(DeleteTopicRequest deleteTopicRequest) {
    return null;
  }

  @Override
  public DeleteTopicResult deleteTopic(String topicArn) {
    return null;
  }

  @Override
  public GetEndpointAttributesResult getEndpointAttributes(GetEndpointAttributesRequest getEndpointAttributesRequest) {
    return null;
  }

  @Override
  public GetPlatformApplicationAttributesResult getPlatformApplicationAttributes
      (GetPlatformApplicationAttributesRequest getPlatformApplicationAttributesRequest) {
    return null;
  }

  @Override
  public GetSMSAttributesResult getSMSAttributes(GetSMSAttributesRequest getSMSAttributesRequest) {
    return null;
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
    return null;
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(String subscriptionArn) {
    return null;
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(GetTopicAttributesRequest getTopicAttributesRequest) {
    return null;
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(String topicArn) {
    return null;
  }

  @Override
  public ListEndpointsByPlatformApplicationResult listEndpointsByPlatformApplication(ListEndpointsByPlatformApplicationRequest listEndpointsByPlatformApplicationRequest) {
    return null;
  }

  @Override
  public ListPhoneNumbersOptedOutResult listPhoneNumbersOptedOut(ListPhoneNumbersOptedOutRequest listPhoneNumbersOptedOutRequest) {
    return null;
  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications(ListPlatformApplicationsRequest
                                                                       listPlatformApplicationsRequest) {
    return null;
  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications() {
    return null;
  }

  @Override
  public ListSubscriptionsResult listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) {
    return null;
  }

  @Override
  public ListSubscriptionsResult listSubscriptions() {
    return null;
  }

  @Override
  public ListSubscriptionsResult listSubscriptions(String nextToken) {
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String topicArn) {
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String topicArn, String nextToken) {
    return null;
  }

  @Override
  public ListTopicsResult listTopics(ListTopicsRequest listTopicsRequest) {
    return null;
  }

  @Override
  public ListTopicsResult listTopics() {
    return null;
  }

  @Override
  public ListTopicsResult listTopics(String nextToken) {
    return null;
  }

  @Override
  public OptInPhoneNumberResult optInPhoneNumber(OptInPhoneNumberRequest optInPhoneNumberRequest) {
    return null;
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
    return null;
  }

  @Override
  public RemovePermissionResult removePermission(String topicArn, String label) {
    return null;
  }

  @Override
  public SetEndpointAttributesResult setEndpointAttributes(SetEndpointAttributesRequest setEndpointAttributesRequest) {
    return null;
  }

  @Override
  public SetPlatformApplicationAttributesResult setPlatformApplicationAttributes
      (SetPlatformApplicationAttributesRequest setPlatformApplicationAttributesRequest) {
    return null;
  }

  @Override
  public SetSMSAttributesResult setSMSAttributes(SetSMSAttributesRequest setSMSAttributesRequest) {
    return null;
  }

  @Override
  public SetSubscriptionAttributesResult setSubscriptionAttributes(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
    return null;
  }

  @Override
  public SetSubscriptionAttributesResult setSubscriptionAttributes(String subscriptionArn, String attributeName,
                                                                   String attributeValue) {
    return null;
  }

  @Override
  public SetTopicAttributesResult setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) {
    return null;
  }

  @Override
  public SetTopicAttributesResult setTopicAttributes(String topicArn, String attributeName, String attributeValue) {
    return null;
  }

  @Override
  public SubscribeResult subscribe(SubscribeRequest subscribeRequest) {
    return null;
  }

  @Override
  public SubscribeResult subscribe(String topicArn, String protocol, String endpoint) {
    return null;
  }

  @Override
  public UnsubscribeResult unsubscribe(UnsubscribeRequest unsubscribeRequest) {
    return null;
  }

  @Override
  public UnsubscribeResult unsubscribe(String subscriptionArn) {
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
