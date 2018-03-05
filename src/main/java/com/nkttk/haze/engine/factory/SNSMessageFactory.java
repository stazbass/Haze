package com.nkttk.haze.engine.factory;

import com.nkttk.haze.engine.component.sns.entities.SNSMessage;

/**
 *
 */
public class SNSMessageFactory {
    public SNSMessage buildMessage(String body) {
        return new SNSMessage(body);
    }
}
