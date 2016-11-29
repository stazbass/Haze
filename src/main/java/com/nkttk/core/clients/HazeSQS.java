package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.nkttk.core.components.sqs.SQSInstance;
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
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  @Override
  public void setRegion(Region region) {

  }

  @Override
  public AddPermissionResult addPermission(AddPermissionRequest addPermissionRequest) {
    return null;
  }

  @Override
  public AddPermissionResult addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions) {
    return null;
  }

  @Override
  public ChangeMessageVisibilityResult changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
    return null;
  }

  @Override
  public ChangeMessageVisibilityResult changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout) {
    return null;
  }

  @Override
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
    return null;
  }

  @Override
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries) {
    return null;
  }

  @Override
  public CreateQueueResult createQueue(CreateQueueRequest createQueueRequest) {
    CreateQueueResult result = new CreateQueueResult();
    SQSInstance instance = engine.addSQS(createQueueRequest.getQueueName());
    result.setQueueUrl(instance.getEndpointURL());
    return result;
  }

  @Override
  public CreateQueueResult createQueue(String queueName) {
    CreateQueueResult result = new CreateQueueResult();
    SQSInstance instance = engine.addSQS(queueName);
    result.setQueueUrl(instance.getEndpointURL());
    return result;
  }

  @Override
  public DeleteMessageResult deleteMessage(DeleteMessageRequest deleteMessageRequest) {
    return null;
  }

  @Override
  public DeleteMessageResult deleteMessage(String queueUrl, String receiptHandle) {
    return null;
  }

  @Override
  public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) {
    return null;
  }

  @Override
  public DeleteMessageBatchResult deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries) {
    return null;
  }

  @Override
  public DeleteQueueResult deleteQueue(DeleteQueueRequest deleteQueueRequest) {
    return null;
  }

  @Override
  public DeleteQueueResult deleteQueue(String queueUrl) {
    return null;
  }

  @Override
  public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) {
    return null;
  }

  @Override
  public GetQueueAttributesResult getQueueAttributes(String queueUrl, List<String> attributeNames) {
    return null;
  }

  @Override
  public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) throws AmazonClientException {
    GetQueueUrlResult result = new GetQueueUrlResult();
    result.setQueueUrl(engine.getSQSEndpoint(getQueueUrlRequest.getQueueName()));
    return result;
  }


  @Override
  public GetQueueUrlResult getQueueUrl(String queueName) {
    return null;
  }

  @Override
  public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) {
    return null;
  }

  @Override
  public ListQueuesResult listQueues(ListQueuesRequest listQueuesRequest) {
    return null;
  }

  @Override
  public ListQueuesResult listQueues() {
    return null;
  }

  @Override
  public ListQueuesResult listQueues(String queueNamePrefix) {
    return null;
  }

  @Override
  public PurgeQueueResult purgeQueue(PurgeQueueRequest purgeQueueRequest) {
    return null;
  }

  @Override
  public ReceiveMessageResult receiveMessage(ReceiveMessageRequest receiveMessageRequest) throws AmazonClientException {
    String queueEndpoint = receiveMessageRequest.getQueueUrl();
    List<Message> resultMessages = new LinkedList<>();
    ReceiveMessageResult result = new ReceiveMessageResult();
    for(int i = 0; i < receiveMessageRequest.getMaxNumberOfMessages(); i++){
      Message message = engine.getSQSMessage(queueEndpoint);
      resultMessages.add(message);
    }
    result.setMessages(resultMessages);
    return result;
  }

  @Override
  public ReceiveMessageResult receiveMessage(String queueUrl) {
    return null;
  }

  @Override
  public RemovePermissionResult removePermission(RemovePermissionRequest removePermissionRequest) {
    return null;
  }

  @Override
  public RemovePermissionResult removePermission(String queueUrl, String label) {
    return null;
  }

  @Override
  public SendMessageResult sendMessage(SendMessageRequest sendMessageRequest) {
    return null;
  }

  @Override
  public SendMessageResult sendMessage(String queueUrl, String messageBody) {
    return null;
  }

  @Override
  public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) {
    return null;
  }

  @Override
  public SendMessageBatchResult sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries) {
    return null;
  }

  @Override
  public SetQueueAttributesResult setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) {
    return null;
  }

  @Override
  public SetQueueAttributesResult setQueueAttributes(String queueUrl, Map<String, String> attributes) {
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
