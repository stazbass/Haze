package com.nkttk.core.components;

import com.amazonaws.services.sqs.model.Message;
import com.nkttk.core.components.events.BucketEventType;
import com.nkttk.core.components.sns.SNSTopic;
import com.nkttk.core.engine.AWSEngine;
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

  }

  @Test
  public void testAddSNS() throws Exception {
    String topic = "topic_name";
    SNSTopic topicObject = engine.addSNSTopic(topic);
    final StringBuilder messageContentPlaceholder = new StringBuilder();
    engine.addSNSSubscriber(topic, message -> messageContentPlaceholder.append(message));
    String message = "some_mess";
    engine.publishSNSMessage(topicObject.getUrl(), message);
    Assert.assertEquals(messageContentPlaceholder.toString(), message);
  }

  @Test
  public void testGetSQSMessage() throws Exception {

  }

  @Test
  public void testSubscribeSQSToS3Event() throws Exception {

  }

  @Test
  public void testAddBucket() throws Exception {

  }

  @Test
  public void testDispatchS3Event() throws Exception {

  }

  @Test
  public void testRunLambda() throws Exception {
    //    engine.addLambda("test_name", ()->new RequestHandler<Object, String>() {
    //      @Override
    //      public String handleRequest(Object input, Context context) {
    //        System.out.println("Handle request " + input);
    //        return "OK";
    //      }
    //    });
    //    engine.runLambda("test_name", ByteBuffer.wrap("Lambda args".getBytes()));
  }

}