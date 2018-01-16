package com.nkttk.haze.engine.component.sns;

import com.nkttk.haze.engine.component.ComponentIdentifier;
import org.testng.annotations.Test;

import java.util.List;

public class SNSEngineTest {
    @Test
    public void testGetIdentifiers() {
        SNSEngine engine = new SNSEngine();
        List<ComponentIdentifier> identifierList = engine.getIdentifiers();

    }

    @Test
    public void testAddSubscriber() {
    }

    @Test
    public void testPublishMessage() {
    }

    @Test
    public void testAddTopic() {
    }

    @Test
    public void testGetSNSEndpoint() {
    }

    @Test
    public void testGetTopicName() {
    }

}