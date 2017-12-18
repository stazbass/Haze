package com.nkttk.core.engine.component.sns;

import com.nkttk.core.engine.component.ComponentIdentifier;
import org.testng.annotations.Test;

import java.util.List;

public class SNSEngineTest {
    @Test
    public void testGetIdentifiers() throws Exception {
        SNSEngine engine = new SNSEngine();
        List<ComponentIdentifier> identifierList = engine.getIdentifiers();

    }

    @Test
    public void testAddSubscriber() throws Exception {
    }

    @Test
    public void testPublishMessage() throws Exception {
    }

    @Test
    public void testAddTopic() throws Exception {
    }

    @Test
    public void testGetSNSEndpoint() throws Exception {
    }

    @Test
    public void testGetTopicName() throws Exception {
    }

}