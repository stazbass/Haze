package com.nkttk.core.client;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.nkttk.core.engine.component.sqs.SQSInstance;
import com.nkttk.core.engine.ComponentStack;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class HazeSQS implements AmazonSQS {
  private ComponentStack engine;
  private String endpoint;

  public HazeSQS(ComponentStack engine){
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
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public AddPermissionResult addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ChangeMessageVisibilityResult changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ChangeMessageVisibilityResult changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries) {
    throw new RuntimeException("NOT IMPLEMENTED");
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
    return deleteMessage(deleteMessageRequest.getQueueUrl(), deleteMessageRequest.getReceiptHandle());
  }

  @Override
  public DeleteMessageResult deleteMessage(String queueUrl, String receiptHandle) {
    engine.deleteSQSMessage(queueUrl, receiptHandle);
    return new DeleteMessageResult();
  }

  @Override
  public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteMessageBatchResult deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteQueueResult deleteQueue(DeleteQueueRequest deleteQueueRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public DeleteQueueResult deleteQueue(String queueUrl) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetQueueAttributesResult getQueueAttributes(String queueUrl, List<String> attributeNames) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) throws AmazonClientException {
    GetQueueUrlResult result = new GetQueueUrlResult();
    result.setQueueUrl(engine.getSQSEndpoint(getQueueUrlRequest.getQueueName()));
    return result;
  }


  @Override
  public GetQueueUrlResult getQueueUrl(String queueName) {
     throw new RuntimeException("NOT IMPLEMENTED");
 }

  @Override
  public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListQueuesResult listQueues(ListQueuesRequest listQueuesRequest) {
     throw new RuntimeException("NOT IMPLEMENTED");
 }

  @Override
  public ListQueuesResult listQueues() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ListQueuesResult listQueues(String queueNamePrefix) {
     throw new RuntimeException("NOT IMPLEMENTED");
 }

  @Override
  public PurgeQueueResult purgeQueue(PurgeQueueRequest purgeQueueRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public ReceiveMessageResult receiveMessage(ReceiveMessageRequest receiveMessageRequest) throws AmazonClientException {
      throw new RuntimeException("Not implemented");
      //    String queueUrl = receiveMessageRequest.getQueueUrl();
//    List<Message> resultMessages = new LinkedList<>();
//    ReceiveMessageResult result = new ReceiveMessageResult();
//    for(int i = 0; i < receiveMessageRequest.getMaxNumberOfMessages(); i++){
//      Message message = engine.getSQSMessageByUrl(queueUrl);
//      if(message != null)
//        resultMessages.add(message);
//      else
//        break;
//    }
//    result.setMessages(resultMessages);
//    return null;
  }

  @Override
  public ReceiveMessageResult receiveMessage(String queueUrl) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public RemovePermissionResult removePermission(RemovePermissionRequest removePermissionRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public RemovePermissionResult removePermission(String queueUrl, String label) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SendMessageResult sendMessage(SendMessageRequest sendMessageRequest) {
    engine.publishSQSMessage(sendMessageRequest.getQueueUrl(), sendMessageRequest.getMessageBody());
    return new SendMessageResult();
  }

  @Override
  public SendMessageResult sendMessage(String queueUrl, String messageBody) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SendMessageBatchResult sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetQueueAttributesResult setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  @Override
  public SetQueueAttributesResult setQueueAttributes(String queueUrl, Map<String, String> attributes) {
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
