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

  public void addInstance(SQSInstance instance) {
    instances.put(instance.getEndpointURL(), instance);
  }

  public void sendMessage(String sqsName, String message) {
    getSQS(sqsName).putMessage(new SQSMessage(message));
  }

  public void sendMessage(String sqsName, SQSMessage message) {
    getSQS(sqsName).putMessage(message);
  }

  public SQSMessage getMessage(String sqsName) {
    SQSMessage message = getSQS(sqsName).getMessage();
    return message;
  }

  public void deleteMessage(String sqsName, String receiptHandle) {
    getSQS(sqsName).deleteMessage(receiptHandle);
  }

  public String getSQSEndpoint(String sqsName){
    for(SQSInstance instance : instances.values()){
      if(instance.getName().equals(sqsName)){
        return instance.getEndpointURL();
      }
    }
    throw new RuntimeException("Cant find sqs with name: " + sqsName);
  }

  private SQSInstance getSQS(String sqsName) {
    if (instances.containsKey(sqsName)) {
      return instances.get(sqsName);
    }
    throw new RuntimeException("Queue not found: " + sqsName);
  }
}
