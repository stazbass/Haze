package com.nkttk.core.engine;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.sqs.model.Message;
import com.nkttk.config.cf.CloudFormationConfig;
import com.nkttk.config.cf.ConfigLoader;
import com.nkttk.config.cf.ResourceType;
import com.nkttk.config.cf.resources.AWSResource;
import com.nkttk.config.cf.resources.BucketResource;
import com.nkttk.config.cf.resources.SNSResource;
import com.nkttk.config.cf.resources.SQSResource;
import com.nkttk.core.components.ComponentIdentifier;
import com.nkttk.core.components.events.BucketEventType;
import com.nkttk.core.components.events.EventBuilder;
import com.nkttk.core.components.lambda.LambdaBuilder;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class AWSEngine {
  private static final Logger LOGGER = LoggerFactory.getLogger(AWSEngine.class);

  private SQSEngine sqsEngine;
  private FSEngine fsEngine;
  private SNSEngine snsEngine;
  private LambdaEngine lambdaEngine;
  private SQSMessageFactory sqsMessageFactory;
  private SNSMessageFactory snsMessageFactory;
  private LambdaBuilder lambdaBuilder = new LambdaBuilder();

  public AWSEngine() {
    this.sqsEngine = new SQSEngine();
    this.fsEngine = new FSEngine();
    this.snsEngine = new SNSEngine();
    this.lambdaEngine = new LambdaEngine(lambdaBuilder);
    this.sqsMessageFactory = new SQSMessageFactory();
    this.snsMessageFactory = new SNSMessageFactory();
  }

  public void setLambdaBuilder(Function<String, RequestHandler<?, ?>> lambdaBuilder) {
    this.lambdaBuilder.setProduceFunction(lambdaBuilder);
  }

  public List<ComponentIdentifier> getAllIdentifiers() {
    List<ComponentIdentifier> result = new LinkedList<>();
    result.addAll(this.sqsEngine.getIdentifiers());
    result.addAll(this.snsEngine.getIdentifiers());
    result.addAll(this.fsEngine.getIdentifiers());
    return result;
  }

  public void loadConfig(InputStream is) throws IOException {
    CloudFormationConfig cf = ConfigLoader.loadConfig(is);
    createComponents(cf);
  }

  private void processComponentSubscriptions(CloudFormationConfig cf) {
    cf.getResources().values().forEach(resource -> {
      switch (resource.getType()) {
        case SQS:
          SQSResource sqsConfig = (SQSResource) resource;
          addSQS(sqsConfig.getProperties().getQueueName());
          break;
        case SNS:
          SNSResource snsResource = (SNSResource) resource;
          snsResource.getProperties().getSubscriptions().forEach(snsSubscription -> {
            switch (snsSubscription.getProtocol()){
              case SQS:
                if(snsSubscription.getSubscriptionEndpoint().getEndpointArn()!=null){
                  throw new RuntimeException("SQS subscription by ARN not implemented");
                }else{
                  String sqsName = snsSubscription.getSubscriptionEndpoint().getGetAttributeFunctionArgs().get(0);
                  String sqsURL = sqsEngine.getSQSEndpoint(sqsName);
                  snsEngine.addSubscriber(snsResource.getProperties().getTopicName(), message->{
                    LOGGER.debug("Putting sns message into sqs");
                    sqsEngine.sendMessage(sqsURL, message);
                  });
                }
                break;
            }
          });
          break;
        case BUCKET:
          BucketResource bucket = (BucketResource) resource;
          addBucket(bucket.getProperties().getBucketName());
          break;
        case ALARM:
          break;
        case LAMBDA:
          break;
        case ROLE:
          LOGGER.debug("Ignoring Role");
          break;
        case IAM_POLICY:
          LOGGER.debug("Ignoring IAM policy config");
          break;
        case LAMBDA_VERSION:
          LOGGER.debug("Ignoring lambda version");
          break;
        case EVENT_RULE:
          LOGGER.debug("Ignoring event rule config");
          break;
        case LAMBDA_PERMISSION:
          LOGGER.debug("Ignoring lambda permission");
          break;
        case QUEUE_POLICY:
          LOGGER.debug("Ignoring ");
          break;
        case IAM_MANAGED_POLICY:
          LOGGER.debug("Ignoring ");
          break;
      }
    });
  }

  private void createComponents(CloudFormationConfig cf) {
    cf.getResources().values().forEach(resource -> {
      switch (resource.getType()) {
        case SQS:
          SQSResource sqsConfig = (SQSResource) resource;
          addSQS(sqsConfig.getProperties().getQueueName());
          break;
        case SNS:
          SNSResource snsResource = (SNSResource) resource;
          addSNS(snsResource.getProperties().getTopicName());
          break;
        case BUCKET:
          BucketResource bucket = (BucketResource) resource;
          addBucket(bucket.getProperties().getBucketName());
          break;
        case ALARM:
          break;
        case LAMBDA:
          break;
        case ROLE:
          LOGGER.debug("Ignoring Role");
          break;
        case IAM_POLICY:
          LOGGER.debug("Ignoring IAM policy config");
          break;
        case LAMBDA_VERSION:
          LOGGER.debug("Ignoring lambda version");
          break;
        case EVENT_RULE:
          LOGGER.debug("Ignoring event rule config");
          break;
        case LAMBDA_PERMISSION:
          LOGGER.debug("Ignoring lambda permission");
          break;
        case QUEUE_POLICY:
          LOGGER.debug("Ignoring ");
          break;
        case IAM_MANAGED_POLICY:
          LOGGER.debug("Ignoring ");
          break;
      }
    });
  }

  public void loadCloudFormationConfig(InputStream configContentStream) throws IOException {
    CloudFormationConfig config = ConfigLoader.loadConfig(configContentStream);

  }

  public SNSTopic addSNS(String topic) {
    LOGGER.debug("Add sns {}", topic);
    return snsEngine.addTopic(topic);
  }

  public SQSInstance addSQS(String name) {
    LOGGER.debug("Add sqs {}", name);
    return sqsEngine.addInstance(new SQSInstance(name));
  }

  public void addBucket(String name) {
    LOGGER.debug("Add bucket: {}", name);
    fsEngine.addBucket(name);
  }

  public String getSQSEndpoint(String name) {
    return sqsEngine.getSQSEndpoint(name);
  }

  public void addSNSSubscriber(String topic, Consumer<String> subscriber) {
    LOGGER.debug("Adding subscriber to topic {}", topic);
    snsEngine.addSubscriber(topic, subscriber);
  }

  public Message getSQSMessage(String sqsUrl) {
    LOGGER.debug("Get sqs message on url: {}", sqsUrl);
    SQSMessage message = sqsEngine.getMessage(sqsUrl);
    Message nativeMessage = message != null ? sqsMessageFactory.buildNativeMessage(message) : null;
    return nativeMessage;
  }

  public void publishSNSMessage(String topicURL, String message) {
    String topicName = snsEngine.getTopicName(topicURL);
    LOGGER.debug("Publish SNS message. url:'{}' name: '{}' body: \"{}\"", topicURL, topicName, message);
    snsEngine.publishMessage(topicName, message);
  }

  public void subscribeSQSToS3Event(String sqsUrl, String bucketName, BucketEventType eventType) {
    Bucket bucket = fsEngine.getBucket(bucketName);

    fsEngine.addEventSubscription(bucket, BucketEventType.PUT, event -> {
      String eventJson = JsonMaster.toString(EventBuilder.buildS3Notification(eventType, bucket.getName(), bucket
          .getUrl(), event.getBucketObject().getKey(), event.getBucketObject().getSize(), event.getBucketObject()
                                                                                  .getEtag()));
      LOGGER.debug("Bucket PUT event sent to SQS {}: {}", sqsUrl, eventJson);
      publishSQSMessage(sqsUrl, eventJson);
    });
  }

  public void publishSQSMessage(String url, String messageBody) {
    LOGGER.debug("Publish SQS message. url: '{}' body: \"{}\"", url, messageBody);
    sqsEngine.sendMessage(url, sqsMessageFactory.buildMessage(messageBody));
  }

  public void deleteSQSMessage(String sqs, String receiptHandle) {
    sqsEngine.deleteMessage(sqs, receiptHandle);
  }

  public void addFile(String bucket, String name, String content) {
    LOGGER.debug("Add file. Bucket: {} file: {}", bucket, name);
    fsEngine.addFile(bucket, name, content);
  }

  public void addFile(String bucket, String name, InputStream is) {
    LOGGER.debug("Add file. Bucket: {} file: {}", bucket, name);
    fsEngine.addFile(bucket, name, is);
  }

  public S3Object getObject(String bucket, String file) {
    LOGGER.debug("Get file object. Bucket: {} file: {}", bucket, file);
    BucketObject bucketObject = fsEngine.getBucket(bucket).getFile(file);
    return S3ObjectFactory.buildS3Object(bucket, bucketObject);
  }

  public ByteBuffer runLambda(String name, ByteBuffer args) throws IOException, ClassNotFoundException {
    LOGGER.debug("Run lambda. Name : {} , args: {}", name);
    return lambdaEngine.runLambda(name, args);
  }

}
