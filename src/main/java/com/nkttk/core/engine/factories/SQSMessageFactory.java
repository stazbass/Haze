package com.nkttk.core.engine.factories;

import com.amazonaws.services.sqs.model.Message;
import com.nkttk.core.components.sqs.entities.SQSMessage;
import com.nkttk.json.JsonMaster;

import java.io.IOException;
import java.util.UUID;

/**
 *
 */
public class SQSMessageFactory {
  /**
   * Getting from queue
   * @param message
   * @return
   */
  public static Message buildNativeMessage(SQSMessage message){
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
  public static SQSMessage buildMessage(String body){
    Message message = new Message();
    message.setBody(body);
    SQSMessage result = new SQSMessage(JsonMaster.toString(message));
    return result;
  }

}
