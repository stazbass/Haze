package com.nkttk.core.components.sqs;

import com.nkttk.core.components.sqs.entities.SQSMessage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SQSEngineTest {
    @Test
    public void testSendMessage() throws Exception {
        SQSEngine engine = new SQSEngine();
        engine.addInstance(new SQSInstance("sqs_name"));
        String endpointUrl = engine.getInstanceByName("sqs_name").getEndpointURL();
        engine.sendMessage(endpointUrl, "some_message");
        SQSMessage message = engine.pullMessage(endpointUrl).get();
        System.out.println(message.getBody());
        assertEquals("some_message", message.getBody());
    }

    @Test
    public void testSendMessage1() throws Exception {

    }

    @Test
    public void testGetMessage() throws Exception {

    }

    @Test
    public void testDeleteMessage() throws Exception {

    }

    @Test
    public void testGetSQSEndpoint() throws Exception {

    }

}