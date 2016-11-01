package com.nkttk.engine.components.sns;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class SNSEngine {
  List<SNSTopic> topics = new LinkedList<>();

  public SNSEngine(){
  }

  public void addSubscriber(String topicName, Consumer<String> subscriber){
    getTopic(topicName).addSubscriber(subscriber);
  }

  public void publishMessage(String topic, String message){
    getTopic(topic).publishMessage(message);
  }

  public void addTopic(String topic){
    topics.add(new SNSTopic(topic));
  }

  private SNSTopic getTopic(String name){
    for(SNSTopic topic : topics){
      if(topic.getName().equals(name)){
        return topic;
      }
    }
    throw new RuntimeException("SNS topic not found : " + name);
  }


}
