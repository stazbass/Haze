package com.nkttk.haze.engine.factory;

import com.amazonaws.services.sqs.model.Message;
import com.nkttk.haze.engine.component.sqs.entities.SQSMessage;
import com.nkttk.haze.json.JsonMaster;

import java.io.IOException;

/**
 *
 */
public class SQSMessageFactory {
    /**
     * Getting from queue
     *
     * @param message
     * @return
     */
    public static Message buildNativeMessage(SQSMessage message) {
        Message result;
        try {
            result = JsonMaster.readValue(message.getBody(), Message.class);
            result.setReceiptHandle(message.getReceiptHandle());
        } catch (IOException e) {
            throw new RuntimeException("SQS message deserialization failed ", e);
        }
        return result;
    }

    /**
     * For putting in queue
     *
     * @param body
     * @return
     */
    public static SQSMessage buildMessage(String body) {
        Message message = new Message();
        message.setBody(body);
        SQSMessage result = new SQSMessage(JsonMaster.toString(message));
        result.setReceiptHandle(message.getReceiptHandle());
        return result;
    }

}
