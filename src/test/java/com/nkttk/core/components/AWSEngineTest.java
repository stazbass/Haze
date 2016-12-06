package com.nkttk.core.components;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.sqs.model.Message;
import com.nkttk.core.engine.AWSEngine;
import com.nkttk.core.components.events.BucketEventType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.ByteBuffer;

/**
 *
 */
public class AWSEngineTest {
  AWSEngine engine;
  @BeforeMethod
  public void setUp() throws Exception {
    engine = new AWSEngine();
  }

  @AfterMethod
  public void tearDown() throws Exception {

  }

  @Test
  public void testAddSQS() throws Exception {
    String name = "sqs_url";
    engine.addSQS(name);
    String url = engine.getSQSEndpoint(name);
    engine.publishSQSMessage(url, "some_message_body");
    Message message = engine.getSQSMessage(url);
    Assert.assertNotNull(message);
    Assert.assertEquals(message.getBody(), "some_message_body");
  }

  @Test
  public void testAddSNS() throws Exception {
    String topic = "topic_name";
    engine.addSNS(topic);
    final StringBuilder messageContentPlaceholder = new StringBuilder();
    engine.addSNSSubscriber(topic, message -> messageContentPlaceholder.append(message));
    String message = "some_mess";
    engine.publishSNSMessage(topic, message);
    Assert.assertEquals(messageContentPlaceholder.toString(), message);
  }

  @Test
  public void testGetSQSMessage() throws Exception {

  }

  @Test
  public void testSubscribeSQSToS3Event() throws Exception {
    String sqs_name = "sqs_url";
    String bucketName = "bucket_name";
    String fileName = "file_name.txt";
    engine.addSQS(sqs_name);
    String sqsUrl = engine.getSQSEndpoint(sqs_name);
    engine.addBucket(bucketName);
    engine.subscribeSQSToS3Event(sqsUrl, bucketName, BucketEventType.PUT);
    engine.addFile(bucketName, fileName, "file_content");

    System.out.println(engine.getSQSMessage(sqsUrl));
  }

  @Test
  public void testAddBucket() throws Exception {

  }

  @Test
  public void testDispatchS3Event() throws Exception {

  }

  @Test
  public void testRunLambda() throws Exception {
    engine.addLambda("test_name", ()->new RequestHandler<Object, String>() {
      @Override
      public String handleRequest(Object input, Context context) {
        System.out.println("Handle request " + input);
        return "OK";
      }
    });
    engine.runLambda("test_name", ByteBuffer.wrap("Lambda args".getBytes()));
  }

}