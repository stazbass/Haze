package com.nkttk.engine.aws;

import com.amazonaws.services.sqs.model.Message;
import com.google.gson.Gson;
import com.nkttk.engine.components.events.BucketEvent;
import com.nkttk.engine.components.events.BucketEventType;
import com.nkttk.engine.components.lambda.LambdaEngine;
import com.nkttk.engine.components.s3.FileServerEngine;
import com.nkttk.engine.components.sns.SNSEngine;
import com.nkttk.engine.components.sqs.SQSEngine;
import com.nkttk.engine.components.sqs.SQSInstance;
import com.nkttk.engine.components.sqs.entities.SQSMessage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class AWSEngine {
  private SQSEngine sqsEngine;
  private FileServerEngine fileServerEngine;
  private SNSEngine snsEngine;
  private LambdaEngine lambdaEngine;
  private Map<BucketEventType, String> s3EventSQSSubscribers;
  private Map<String, String> scheduledEventLambdaSubscribers;
  private SQSMessageBuilder sqsMessageBuilder;
  private SNSMessageBuilder snsMessageBuilder;

  public AWSEngine() {
    this.sqsEngine = new SQSEngine();
    this.fileServerEngine = new FileServerEngine();
    this.snsEngine = new SNSEngine();
    this.lambdaEngine = new LambdaEngine();
    this.sqsMessageBuilder = new SQSMessageBuilder();
    this.s3EventSQSSubscribers = new LinkedHashMap<>();
    this.scheduledEventLambdaSubscribers = new LinkedHashMap<>();
  }

  public void addSQS(String url) {
    sqsEngine.addInstance(new SQSInstance(url));
  }

  public void addSNS(String topic) {
    snsEngine.addTopic(topic);
  }

  public void addSNSSubscriber(String topic, Consumer<String> subscriber){
    snsEngine.addSubscriber(topic, subscriber);
  }

  public Message getSQSMessage(String url) {
    SQSMessage message = sqsEngine.getMessage(url);
    Message nativeMessage = sqsMessageBuilder.buildMessage(message);
    return nativeMessage;
  }

  public void publishSNSMessage(String topic, String message){
    snsEngine.publishMessage(topic, message);
  }

  public void publishSQSMessage(String url, String messageBody) {
    sqsEngine.sendMessage(url, sqsMessageBuilder.buildNewMessage(messageBody));
  }

  public void subscribeSQSToS3Event(String sqsUrl, String bucket, BucketEventType eventType) {
    fileServerEngine.addEventSubscription(bucket, BucketEventType.ADD, event->{
      sqsEngine.sendMessage(sqsUrl, );
    });
  }

  public void addBucket(String name) {

  }

  public void dispatchS3Event(BucketEvent event) {
    s3EventSQSSubscribers.values().forEach(url -> sqsEngine.sendMessage(url, new Gson().toJson(event)));
  }

  public void runLambda(String name, Object args) {
    lambdaEngine.runLambda(name, args);
  }
}
