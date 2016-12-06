package com.nkttk.core.engine;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.sqs.model.Message;
import com.nkttk.core.components.ComponentIdentifier;
import com.nkttk.core.components.events.BucketEventType;
import com.nkttk.core.components.events.EventBuilder;
import com.nkttk.core.clients.LambdaClient;
import com.nkttk.core.components.lambda.LambdaEngine;
import com.nkttk.core.components.s3.Bucket;
import com.nkttk.core.components.s3.BucketObject;
import com.nkttk.core.components.s3.FSEngine;
import com.nkttk.core.components.sns.SNSEngine;
import com.nkttk.core.components.sns.SNSTopic;
import com.nkttk.core.components.sqs.SQSEngine;
import com.nkttk.core.components.sqs.SQSInstance;
import com.nkttk.core.components.sqs.entities.SQSMessage;
import com.nkttk.core.engine.factories.S3ObjectFactory;
import com.nkttk.core.engine.factories.SNSMessageFactory;
import com.nkttk.core.engine.factories.SQSMessageFactory;
import com.nkttk.json.JsonMaster;
import com.nkttk.config.HazeDescription;
import com.nkttk.config.LambdaDescription;
import com.nkttk.config.SNSDescription;
import com.nkttk.config.SQSDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AWSEngine {
  private static final Logger LOGGER = LoggerFactory.getLogger(AWSEngine.class);
  private SQSEngine sqsEngine;
  private FSEngine fsEngine;
  private SNSEngine snsEngine;
  private LambdaEngine lambdaEngine;
  private SQSMessageFactory sqsMessageFactory;
  private SNSMessageFactory snsMessageFactory;


  private Consumer<RequestHandler> lambdaDependencyInjector;

  public AWSEngine() {
    this.sqsEngine = new SQSEngine();
    this.fsEngine = new FSEngine();
    this.snsEngine = new SNSEngine();
    this.lambdaEngine = new LambdaEngine();
    this.sqsMessageFactory = new SQSMessageFactory();
    this.snsMessageFactory = new SNSMessageFactory();
  }

  public List<ComponentIdentifier> getAllIdentifiers(){
    List<ComponentIdentifier> result = new LinkedList<>();
    result.addAll(this.sqsEngine.getIdentifiers());
    result.addAll(this.snsEngine.getIdentifiers());
    result.addAll(this.fsEngine.getIdentifiers());
    return result;
  }

  public void loadConfig(HazeDescription desc){
    LOGGER.info("Loading cloud description : " + desc);
    for(SNSDescription snsDesc : desc.getNotificationServices()){
      addSNS(snsDesc.getTopic());
    }
    for(SQSDescription sqsDesc : desc.getQueueServices()){
      addSQS(sqsDesc.getName());
    }
    for(String bucket : desc.getBuckets()){
      addBucket(bucket);
    }
    for(LambdaDescription lambdaDescription : desc.getFunctions()){
      addLambda(lambdaDescription.getName(), lambdaDescription.getInstanceSupplier());
    }
  }

  public SQSInstance addSQS(String name) {
    LOGGER.debug("Add sqs {}", name);
    return sqsEngine.addInstance(new SQSInstance(name));
  }

  public String getSQSEndpoint(String name){
    return sqsEngine.getSQSEndpoint(name);
  }

  public String getSNSEndpoint(String topicName){
    return snsEngine.getSNSEndpoint(topicName);
  }

  public SNSTopic addSNS(String topic) {
    LOGGER.debug("Add sns {}", topic);
    return snsEngine.addTopic(topic);
  }

  public void addSNSSubscriber(String topic, Consumer<String> subscriber) {
    snsEngine.addSubscriber(topic, subscriber);
  }

  public Message getSQSMessage(String sqsUrl) {
    LOGGER.debug("Get sqs message on url: {}", sqsUrl);
    SQSMessage message = sqsEngine.getMessage(sqsUrl);
    Message nativeMessage = message!=null ? sqsMessageFactory.buildNativeMessage(message):null;
    return nativeMessage;
  }

  public void publishSNSMessage(String topic, String message) {
    LOGGER.debug("Publish SNS message. topic: '{}' body: \"{}\"", topic, message);
    snsEngine.publishMessage(topic, message);
  }

  public void publishSQSMessage(String url, String messageBody) {
    LOGGER.debug("Publish SNS message. topic: '{}' body: \"{}\"", url, messageBody);
    sqsEngine.sendMessage(url, sqsMessageFactory.buildMessage(messageBody));
  }

  public void subscribeSQSToS3Event(String sqsUrl, String bucketName, BucketEventType eventType) {
    Bucket bucket = fsEngine.getBucket(bucketName);

    fsEngine.addEventSubscription(bucket,
                                  BucketEventType.PUT,
                                  event -> {
                                    String eventJson = JsonMaster.toString(EventBuilder.buildS3Notification(eventType,
                                                                                                            bucket.getName(),
                                                                                                            bucket.getUrl(),
                                                                                                            event.getBucketObject().getKey(),
                                                                                                            event.getBucketObject().getSize(),
                                                                                                            event.getBucketObject().getEtag()));
                                    publishSQSMessage(sqsUrl, eventJson);
                                  });
  }

  public void addBucket(String name) {
    LOGGER.debug("Add bucket: ", name);
    fsEngine.addBucket(name);
  }

  public void addFile(String bucket, String name, String content){
    LOGGER.debug("Add file. Bucket: {} file: {}", bucket, name);
    fsEngine.addFile(bucket, name, content);
  }

  public void addFile(String bucket, String name, InputStream is){
    LOGGER.debug("Add file. Bucket: {} file: {}", bucket, name);
    fsEngine.addFile(bucket, name, is);
  }

  public S3Object getObject(String bucket, String file){
    LOGGER.debug("Get file object. Bucket: {} file: {}", bucket, file);
    BucketObject bucketObject = fsEngine.getBucket(bucket).getFile(file);
    return S3ObjectFactory.buildS3Object(bucket, bucketObject);
  }

  public ByteBuffer runLambda(String name, ByteBuffer args) throws IOException {
    LOGGER.debug("Run lambda. Name : {} , args: {}", name, args);
    return lambdaEngine.runLambda(name, args);
  }

  public <I,O>void addLambda(String name, Supplier<RequestHandler<I, O>> instanceSupplier){
    LOGGER.debug("Add lambda. Name: {}", name);
    lambdaEngine.addLambda(name, instanceSupplier);
  }

//  public LambdaClient provideLambdaClient(String name){
//    return new LambdaClient((I)->runLambda(name, I));
//  }
}
