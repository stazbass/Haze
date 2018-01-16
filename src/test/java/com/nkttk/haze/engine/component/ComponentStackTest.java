package com.nkttk.haze.engine.component;

import com.nkttk.haze.engine.component.sns.SNSTopic;
import com.nkttk.haze.engine.ComponentStack;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
public class ComponentStackTest {
  ComponentStack engine;

  @BeforeMethod
  public void setUp() {
    engine = new ComponentStack();
  }

  @AfterMethod
  public void tearDown() {

  }

  @Test
  public void testAddSQS() {

  }

  @Test
  public void testAddSNS() {
    String topic = "topic_name";
    SNSTopic topicObject = engine.addSNSTopic(topic);
    final StringBuilder messageContentPlaceholder = new StringBuilder();
    engine.addSNSSubscriber(topic, message -> messageContentPlaceholder.append(message));
    String message = "some_mess";
    engine.publishSNSMessage(topicObject.getUrl(), message);
    Assert.assertEquals(messageContentPlaceholder.toString(), message);
  }

  @Test
  public void testGetSQSMessage() {

  }

  @Test
  public void testSubscribeSQSToS3Event() {

  }

  @Test
  public void testAddBucket() {

  }

  @Test
  public void testDispatchS3Event() {

  }

  @Test
  public void testRunLambda() {
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