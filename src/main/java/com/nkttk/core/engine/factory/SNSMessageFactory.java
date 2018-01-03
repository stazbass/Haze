package com.nkttk.core.engine.factory;

import com.nkttk.core.engine.component.sns.entities.SNSMessage;

/**
 *
 */
public class SNSMessageFactory {
    public SNSMessage buildMessage(String body) {
        return new SNSMessage(body);
    }
}
