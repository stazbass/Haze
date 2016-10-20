package com.nkttk.components.sqs.entities;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by cryptobat on 10/20/2016.
 */
public class SQSInstanceTest {
  SQSInstance instance;

  @BeforeMethod
  public void before_method(){
    instance = new SQSInstance("url");
  }

  @Test
  public void test_put_get(){
    instance.putMessage(new SQSMessage("message_body"));
    SQSMessage message = instance.getMessage();
    assertEquals(message.getBody(), "message_body");
  }
  @Test
  public void test_delete(){
    instance.putMessage(new SQSMessage("test1"));
    SQSMessage message = instance.getMessage();
    instance.deleteMessage(message.getReceiptHandle());
    assertEquals(message.getBody(), "test1");
  }
  @Test
  public void test_restore() throws InterruptedException {
    instance.setMessageLockInterval(100);
    instance.putMessage(new SQSMessage("test1"));
    SQSMessage message1 = instance.getMessage();
    Thread.sleep(150);
    SQSMessage message2 = instance.getMessage();
    assertEquals(message1.getId(), message2.getId());
  }
  @Test
  public void test_not_yet_restored() throws InterruptedException {
    instance.putMessage(new SQSMessage("test1"));
    SQSMessage message1 = instance.getMessage();
    SQSMessage message2 = instance.getMessage();
    assertNull(message2);
  }
}