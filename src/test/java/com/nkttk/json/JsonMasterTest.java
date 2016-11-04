package com.nkttk.json;

import com.amazonaws.services.sqs.model.Message;
import org.testng.annotations.Test;

/**
 *
 */
public class JsonMasterTest {
  @Test
  public void testReadValue() throws Exception {
    Message message = new Message();
    String json = JsonMaster.toString(message);
    Message result = JsonMaster.readValue(json, Message.class);
    System.out.println(json);
  }
}