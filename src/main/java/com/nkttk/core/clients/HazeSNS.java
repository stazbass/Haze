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
  public void setEndpoint(String s) throws IllegalArgumentException {

  }

  @Override
  public void setRegion(Region region) throws IllegalArgumentException {

  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public CreatePlatformApplicationResult createPlatformApplication(CreatePlatformApplicationRequest createPlatformApplicationRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(GetTopicAttributesRequest getTopicAttributesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public SubscribeResult subscribe(SubscribeRequest subscribeRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void deleteEndpoint(DeleteEndpointRequest deleteEndpointRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void removePermission(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public GetEndpointAttributesResult getEndpointAttributes(GetEndpointAttributesRequest getEndpointAttributesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListSubscriptionsResult listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public CreatePlatformEndpointResult createPlatformEndpoint(CreatePlatformEndpointRequest createPlatformEndpointRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setSubscriptionAttributes(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public CreateTopicResult createTopic(CreateTopicRequest createTopicRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListTopicsResult listTopics(ListTopicsRequest listTopicsRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void deletePlatformApplication(DeletePlatformApplicationRequest deletePlatformApplicationRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications(ListPlatformApplicationsRequest listPlatformApplicationsRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setEndpointAttributes(SetEndpointAttributesRequest setEndpointAttributesRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void unsubscribe(UnsubscribeRequest unsubscribeRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void deleteTopic(DeleteTopicRequest deleteTopicRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public GetPlatformApplicationAttributesResult getPlatformApplicationAttributes(GetPlatformApplicationAttributesRequest getPlatformApplicationAttributesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setPlatformApplicationAttributes(SetPlatformApplicationAttributesRequest setPlatformApplicationAttributesRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void addPermission(AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ListEndpointsByPlatformApplicationResult listEndpointsByPlatformApplication(ListEndpointsByPlatformApplicationRequest listEndpointsByPlatformApplicationRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public PublishResult publish(PublishRequest publishRequest) throws AmazonServiceException, AmazonClientException {
    engine.publishSNSMessage(publishRequest.getTopicArn(), publishRequest.getMessage());
    return new PublishResult();
  }

  @Override
  public ListSubscriptionsResult listSubscriptions() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListTopicsResult listTopics() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(String s, String s1, String s2) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(String s, String s1) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(String s) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public SubscribeResult subscribe(String s, String s1, String s2) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setTopicAttributes(String s, String s1, String s2) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void removePermission(String s, String s1) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ListSubscriptionsResult listSubscriptions(String s) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setSubscriptionAttributes(String s, String s1, String s2) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public CreateTopicResult createTopic(String s) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(String s) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListTopicsResult listTopics(String s) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void unsubscribe(String s) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void deleteTopic(String s) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void addPermission(String s, String s1, List<String> list, List<String> list1) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String s, String s1) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(String s) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public PublishResult publish(String s, String s1) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public PublishResult publish(String s, String s1, String s2) throws AmazonServiceException, AmazonClientException {
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
