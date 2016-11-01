package com.nkttk.engine.aws;

import com.amazonaws.services.sqs.model.Message;
import com.nkttk.engine.components.sqs.entities.SQSMessage;
import com.nkttk.json.JsonMaster;

import java.io.IOException;
import java.util.UUID;

/**
 *
 */
public class SQSMessageBuilder {
  /**
   * Getting from queue
   * @param message
   * @return
   */
  public static Message buildMessage(SQSMessage message){
    Message result;
    try {
      result = JsonMaster.readValue(message.getBody(), Message.class);
    } catch (IOException e) {
      throw new RuntimeException("SQS message deserialization failed ", e);
    }
    return result;
  }

  /**
   * For putting in queue
   * @param body
   * @return
   */
  public static SQSMessage buildNewMessage(String body){
    String id = UUID.randomUUID().toString();
    Message message = new Message();
    message.setMessageId(id);
    message.setBody(body);
    SQSMessage result = new SQSMessage(id, JsonMaster.toString(message));
    return result;
  }

}
