package com.nkttk.core.engine;

import com.amazonaws.services.sqs.model.Message;
import com.nkttk.core.components.events.BucketEventType;
import com.nkttk.core.components.events.EventBuilder;
import com.nkttk.core.components.lambda.LambdaEngine;
import com.nkttk.core.components.s3.Bucket;
import com.nkttk.core.components.s3.FSEngine;
import com.nkttk.core.components.sns.SNSEngine;
import com.nkttk.core.components.sqs.SQSEngine;
import com.nkttk.core.components.sqs.SQSInstance;
import com.nkttk.core.components.sqs.entities.SQSMessage;
import com.nkttk.core.engine.factories.SNSMessageFactory;
import com.nkttk.core.engine.factories.SQSMessageFactory;
import com.nkttk.json.JsonMaster;

import java.util.function.Consumer;

public class AWSEngine {
  private SQSEngine sqsEngine;
  private FSEngine fsEngine;
  private SNSEngine snsEngine;
  private LambdaEngine lambdaEngine;
  private SQSMessageFactory sqsMessageFactory;
  private SNSMessageFactory snsMessageFactory;

  public AWSEngine() {
    this.sqsEngine = new SQSEngine();
    this.fsEngine = new FSEngine();
    this.snsEngine = new SNSEngine();
    this.lambdaEngine = new LambdaEngine();
    this.sqsMessageFactory = new SQSMessageFactory();
  }

  public void addSQS(String url) {
    sqsEngine.addInstance(new SQSInstance(url));
  }

  public void addSNS(String topic) {
    snsEngine.addTopic(topic);
  }

  public void addSNSSubscriber(String topic, Consumer<String> subscriber) {
    snsEngine.addSubscriber(topic, subscriber);
  }

  public Message getSQSMessage(String url) {
    SQSMessage message = sqsEngine.getMessage(url);
    Message nativeMessage = sqsMessageFactory.buildMessage(message);
    return nativeMessage;
  }

  public void publishSNSMessage(String topic, String message) {
    snsEngine.publishMessage(topic, message);
  }

  public void publishSQSMessage(String url, String messageBody) {
    sqsEngine.sendMessage(url, sqsMessageFactory.buildNewMessage(messageBody));
  }

  public void subscribeSQSToS3Event(String sqsUrl, String bucketName, BucketEventType eventType) {
    Bucket bucket = fsEngine.getBucket(bucketName);

    fsEngine.addEventSubscription(bucket,
                                  BucketEventType.PUT,
                                  event -> {
                                    String eventJson = JsonMaster.toString(EventBuilder.buildS3Notification(eventType,
                                                                                                            bucket.getName(),
                                                                                                            bucket.getArn(),
                                                                                                            event.getBucketObject().getKey(),
                                                                                                            event.getBucketObject().getSize(),
                                                                                                            event.getBucketObject().getEtag()));
                                    publishSQSMessage(sqsUrl, eventJson);
                                  });
  }

  public void addBucket(String name) {
    fsEngine.addBucket(name);
  }

  public void addFile(String bucket, String name, String content){
    fsEngine.addFile(bucket, name, content);
  }

  public void runLambda(String name, Object args) {
    lambdaEngine.runLambda(name, args);
  }
}
