package com.nkttk.core.engine.component.sqs.entities;

import com.nkttk.core.engine.component.sqs.SQSInstance;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class SQSInstanceTest {
  SQSInstance instance;

  @BeforeMethod
  public void before_method() {
    instance = new SQSInstance("url");
  }

  @Test
  public void test_put_get() {
    instance.putMessage(new SQSMessage("message_body"));
    Optional<SQSMessage> message = instance.getMessage();
    assertTrue(message.isPresent());
  }

  @Test
  public void test_delete() {
    instance.putMessage(new SQSMessage("test1"));
    SQSMessage message = instance.getMessage().get();
    instance.deleteMessage(message.getReceiptHandle());
    assertEquals(message.getBody(), "test1");
  }

  @Test
  public void test_restore() throws InterruptedException {
    instance.setMessageLockInterval(100);
    instance.putMessage(new SQSMessage("test1"));

  }

  @Test
  public void test_not_yet_restored() throws InterruptedException {
//    instance.putMessage(new SQSMessage("test1"));
//    assertNull(message2);
  }
}