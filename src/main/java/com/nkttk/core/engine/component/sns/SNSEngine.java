package com.nkttk.core.engine.component.sns;

import com.nkttk.core.engine.component.ComponentIdentifier;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class SNSEngine {
    List<SNSTopic> topics = new LinkedList<>();

    public SNSEngine() {
    }

    public List<ComponentIdentifier> getIdentifiers() {
        List<ComponentIdentifier> identifiers = new LinkedList<>();
        for (SNSTopic topic : topics) {
            identifiers.add(new ComponentIdentifier(topic.getName(), topic.getUrl()));
        }
        return identifiers;
    }

    public void addSubscriber(String topicName, Consumer<String> subscriber) {
        getTopic(topicName).addSubscriber(subscriber);
    }

    public void publishMessage(String topicName, String message) {
        getTopic(topicName).publishMessage(message);
    }

    public SNSTopic addTopic(String topic) {
        SNSTopic result = new SNSTopic(topic);
        topics.add(result);
        return result;
    }

    public String getSNSEndpoint(String topicName) {
        return getTopic(topicName).getUrl();
    }

    public String getTopicName(String topicARN) {
        for (SNSTopic topic : topics) {
            if (topicARN.equals(topic.getUrl())) {
                return topic.getName();
            }
        }
        throw new RuntimeException("Topic not found : " + topicARN);
    }

    private SNSTopic getTopic(String name) {
        for (SNSTopic topic : topics) {
            if (topic.getName().equals(name)) {
                return topic;
            }
        }
        throw new RuntimeException("SNS topic not found : " + name);
    }
}
