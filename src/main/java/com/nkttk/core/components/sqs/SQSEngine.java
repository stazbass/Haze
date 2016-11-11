package com.nkttk.core.components.sqs;

import com.nkttk.core.components.sqs.entities.SQSMessage;

import java.util.HashMap;
import java.util.Map;

public class SQSEngine {
  private Map<String, SQSInstance> instances = new HashMap<>();

  public void addInstance(SQSInstance instance) {
    instances.put(instance.getEndpointURL(), instance);
  }

  public void sendMessage(String url, String message) {
    getSQS(url).putMessage(new SQSMessage(message));
  }

  public void sendMessage(String url, SQSMessage message) {
    getSQS(url).putMessage(message);
  }

  public SQSMessage getMessage(String url) {
    SQSMessage message = getSQS(url).getMessage();
    return message;
  }

  public void deleteMessage(String url, String receiptHandle) {
    getSQS(url).deleteMessage(receiptHandle);
  }

  public String getSQSEndpoint(String name){
    for(SQSInstance instance : instances.values()){
      if(instance.getName().equals(name)){
        return instance.getEndpointURL();
      }
    }
    throw new RuntimeException("Cant find sqs with name: " + name);
  }

  private SQSInstance getSQS(String url) {
    if (instances.containsKey(url)) {
      return instances.get(url);
    }
    throw new RuntimeException("Queue not found: " + url);
  }
}
