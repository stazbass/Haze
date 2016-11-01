package com.nkttk.engine.aws;

import com.nkttk.engine.components.sns.entities.SNSMessage;

/**
 *
 */
public class SNSMessageBuilder {
  public SNSMessage buildMessage(String body){
    return new SNSMessage(body);
  }
}
