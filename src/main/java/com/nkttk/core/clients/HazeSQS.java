package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.nkttk.core.engine.AWSEngine;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HazeSQS implements AmazonSQS {
  private AWSEngine engine;
  private String endpoint;

  public HazeSQS(AWSEngine engine){
    this.engine = engine;
  }

  @Override
  public void setEndpoint(String endpoint) throws IllegalArgumentException {
    this.endpoint = endpoint;
  }

  @Override
  public void setRegion(Region region) throws IllegalArgumentException {

  }

  @Override
  public void setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) throws AmazonServiceException, AmazonClientException {
    GetQueueUrlResult result = new GetQueueUrlResult();
    result.setQueueUrl(engine.getSQSEndpoint(getQueueUrlRequest.getQueueName()));
    return result;
  }

  @Override
  public void removePermission(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void deleteQueue(DeleteQueueRequest deleteQueueRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public SendMessageResult sendMessage(SendMessageRequest sendMessageRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ReceiveMessageResult receiveMessage(ReceiveMessageRequest receiveMessageRequest) throws AmazonServiceException, AmazonClientException {
    List<Message> resultMessages = new LinkedList<>();
    ReceiveMessageResult result = new ReceiveMessageResult();
    for(int i = 0; i < receiveMessageRequest.getMaxNumberOfMessages(); i++){
      Message message = engine.getSQSMessage(endpoint);
      resultMessages.add(message);
    }
    result.setMessages(resultMessages);
    return result;
  }

  @Override
  public ListQueuesResult listQueues(ListQueuesRequest listQueuesRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public CreateQueueResult createQueue(CreateQueueRequest createQueueRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void addPermission(AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void deleteMessage(DeleteMessageRequest deleteMessageRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ListQueuesResult listQueues() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setQueueAttributes(String queueUrl, Map<String, String> attributes) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public GetQueueUrlResult getQueueUrl(String queueName) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void removePermission(String queueUrl, String label) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public GetQueueAttributesResult getQueueAttributes(String queueUrl, List<String> attributeNames) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public SendMessageBatchResult sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void deleteQueue(String queueUrl) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public SendMessageResult sendMessage(String queueUrl, String messageBody) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ReceiveMessageResult receiveMessage(String queueUrl) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public ListQueuesResult listQueues(String queueNamePrefix) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DeleteMessageBatchResult deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public CreateQueueResult createQueue(String queueName) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void deleteMessage(String queueUrl, String receiptHandle) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void shutdown() {

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
    return null;
  }
}
