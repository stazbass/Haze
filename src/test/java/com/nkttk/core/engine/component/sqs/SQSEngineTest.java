package com.nkttk.core.engine.component.sqs;

import com.nkttk.core.engine.component.sqs.entities.SQSMessage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SQSEngineTest {
    @Test
    public void testSendMessage() {
        SQSEngine engine = new SQSEngine();
        engine.addInstance(new SQSInstance("sqs_name"));
        String endpointUrl = engine.getInstanceByName("sqs_name").getEndpointURL();
        engine.sendMessage(endpointUrl, "some_message");
        SQSMessage message = engine.pullMessage(endpointUrl).get();
        System.out.println(message.getBody());
        assertEquals("some_message", message.getBody());
    }

    @Test
    public void testSendMessage1() {

    }

    @Test
    public void testGetMessage() {

    }

    @Test
    public void testDeleteMessage() {

    }

    @Test
    public void testGetSQSEndpoint() {

    }

}