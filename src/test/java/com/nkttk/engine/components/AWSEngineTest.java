package com.nkttk.engine.components;

import com.amazonaws.services.sqs.model.Message;
import com.nkttk.engine.aws.AWSEngine;
import com.nkttk.engine.components.events.BucketEventType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    String url = "sqs_url";
    engine.addSQS(url);
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
    String sqsUrl = "sqs_url";
    String bucketName = "bucket_name";
    engine.addSQS(sqsUrl);
    engine.subscribeSQSToS3Event(sqsUrl, bucketName, BucketEventType.ADD);
  }

  @Test
  public void testAddBucket() throws Exception {

  }

  @Test
  public void testDispatchS3Event() throws Exception {

  }

  @Test
  public void testRunLambda() throws Exception {

  }

}