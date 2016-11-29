package com.nkttk.core.components.sqs;

import com.nkttk.core.components.ComponentIdentifier;
import com.nkttk.core.components.sqs.entities.SQSMessage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SQSEngine {
  private Map<String, SQSInstance> instances = new HashMap<>();

  public List<ComponentIdentifier> getIdentifiers(){
    List<ComponentIdentifier> identifiers = new LinkedList<>();
    for(String key : instances.keySet()){
      identifiers.add(new ComponentIdentifier(key, instances.get(key).getEndpointURL()));
    }
    return identifiers;
  }

  public SQSInstance addInstance(SQSInstance instance) {
    instances.put(instance.getEndpointURL(), instance);
    return instance;
  }

  public void sendMessage(String sqsUrl, String message) {
    getSQS(sqsUrl).putMessage(new SQSMessage(message));
  }

  public void sendMessage(String sqsUrl, SQSMessage message) {
    getSQS(sqsUrl).putMessage(message);
  }

  public SQSMessage getMessage(String sqsUrl) {
    SQSMessage message = getSQS(sqsUrl).getMessage();
    return message;
  }

  public void deleteMessage(String sqsUrl, String receiptHandle) {
    getSQS(sqsUrl).deleteMessage(receiptHandle);
  }

  public String getSQSEndpoint(String sqsName){
    for(SQSInstance instance : instances.values()){
      if(instance.getName().equals(sqsName)){
        return instance.getEndpointURL();
      }
    }
    throw new RuntimeException("Cant find sqs with name: " + sqsName);
  }

  private SQSInstance getSQS(String sqsUrl) {
    if (instances.containsKey(sqsUrl)) {
      return instances.get(sqsUrl);
    }
    throw new RuntimeException("Queue not found: " + sqsUrl);
  }
}
