package com.nkttk.core.components.sqs;

import com.nkttk.core.components.ComponentIdentifier;
import com.nkttk.core.components.sqs.entities.SQSMessage;

import java.util.*;
import java.util.stream.Collectors;

public class SQSEngine {
    private List<SQSInstance> instances = new LinkedList<>();

    public List<ComponentIdentifier> getIdentifiers() {
        return instances.stream().map(i -> new ComponentIdentifier(i.getName(), i.getEndpointURL())).collect(Collectors.toList());
    }

    public SQSInstance addInstance(SQSInstance instance) {
        instances.add(instance);
        return instance;
    }

    public void sendMessage(String sqsUrl, String message) {
        getInstanceByURL(sqsUrl).putMessage(new SQSMessage(message));
    }

    public void sendMessage(String sqsUrl, SQSMessage message) {
        getInstanceByURL(sqsUrl).putMessage(message);
    }

    public Optional<SQSMessage> pullMessage(String sqsUrl) {
        return getInstanceByURL(sqsUrl).getMessage();
    }

    public void deleteMessage(String sqsUrl, String receiptHandle) {
        getInstanceByURL(sqsUrl).deleteMessage(receiptHandle);
    }

    public SQSInstance getInstanceByName(String sqsName) {
        return instances.stream().filter(i -> i.getName().equals(sqsName)).findFirst().orElseThrow(() -> new RuntimeException("Instance not found. URL : " + sqsName));
    }

    private SQSInstance getInstanceByURL(String sqsUrl) {
        return instances.stream().filter(i -> i.getEndpointURL().equals(sqsUrl)).findFirst().orElseThrow(() -> new RuntimeException("Instance not found. URL : " + sqsUrl));
    }
}
