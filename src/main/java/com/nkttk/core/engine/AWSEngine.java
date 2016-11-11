package com.nkttk.core.engine;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.sqs.model.Message;
import com.nkttk.core.components.ComponentIdentifier;
import com.nkttk.core.components.events.BucketEventType;
import com.nkttk.core.components.events.EventBuilder;
import com.nkttk.core.components.lambda.LambdaEngine;
import com.nkttk.core.components.s3.Bucket;
import com.nkttk.core.components.s3.BucketObject;
import com.nkttk.core.components.s3.FSEngine;
import com.nkttk.core.components.sns.SNSEngine;
import com.nkttk.core.components.sqs.SQSEngine;
import com.nkttk.core.components.sqs.SQSInstance;
import com.nkttk.core.components.sqs.entities.SQSMessage;
import com.nkttk.core.engine.factories.S3ObjectFactory;
import com.nkttk.core.engine.factories.SNSMessageFactory;
import com.nkttk.core.engine.factories.SQSMessageFactory;
import com.nkttk.json.JsonMaster;
import com.nkttk.yaml.HazeDescription;
import com.nkttk.yaml.LambdaDescription;
import com.nkttk.yaml.SNSDescription;
import com.nkttk.yaml.SQSDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class AWSEngine {
  private static final Logger LOGGER = LoggerFactory.getLogger(AWSEngine.class);
  private SQSEngine sqsEngine;
  private FSEngine fsEngine;
  private SNSEngine snsEngine;
  private LambdaEngine lambdaEngine;
  private SQSMessageFactory sqsMessageFactory;
  private SNSMessageFactory snsMessageFactory;

  public void setLambdaDependencyInjector(Consumer<RequestHandler> lambdaDependencyInjector) {
    this.lambdaDependencyInjector = lambdaDependencyInjector;
  }

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
      addLambda(lambdaDescription.getName(), loadLambda(lambdaDescription.getHandler()));
    }
  }

  public RequestHandler loadLambda(String className){
    LOGGER.debug("Load lambda {}", className);
    try {
      Class classObject = Class.forName(className);
      RequestHandler lambda = (RequestHandler) classObject.newInstance();
      lambdaDependencyInjector.accept(lambda);
      return lambda;
    } catch (Exception e) {
      throw new RuntimeException("Cant find lambda class " + className, e);
    }
  }

  public void addSQS(String name) {
    LOGGER.debug("Add sqs {}", name);
    sqsEngine.addInstance(new SQSInstance(name));
  }

  public String getSQSEndpoint(String name){
    return  sqsEngine.getSQSEndpoint(name);
  }

  public void addSNS(String topic) {
    LOGGER.debug("Add sns {}", topic);
    snsEngine.addTopic(topic);
  }

  public void addSNSSubscriber(String topic, Consumer<String> subscriber) {
    snsEngine.addSubscriber(topic, subscriber);
  }

  public Message getSQSMessage(String url) {
    LOGGER.debug("Get sqs message on url: {}", url);
    SQSMessage message = sqsEngine.getMessage(url);
    Message nativeMessage = sqsMessageFactory.buildNativeMessage(message);
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

  public void runLambda(String name, Object args) {
    LOGGER.debug("Run lambda. Name : {} , args: {}", name, args);
    lambdaEngine.runLambda(name, args);
  }

  public void addLambda(String name, RequestHandler requestHandler){
    LOGGER.debug("Add lambda. Name: {}", name);
    lambdaEngine.addLambda(name, requestHandler);
  }
}