package com.nkttk.core.engine.factories;

import com.nkttk.core.components.sns.entities.SNSMessage;

/**
 *
 */
public class SNSMessageFactory {
  public SNSMessage buildMessage(String body){
    return new SNSMessage(body);
  }
}
