package com.nkttk.engine.components.sns;

import com.nkttk.engine.components.sns.entities.SNSMessage;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cryptobat on 11/1/2016.
 */
public class SNSEngine {
  List<SNSTopic> topics = new LinkedList<>();

  public SNSEngine(){

  }

  public void publishMessage(String topic, SNSMessage message){
    topics.forEach(snsTopic -> {
      if(snsTopic.getName().equals(topic))snsTopic.publishMessage(message);
    });
  }

  public void addTopic(String topic){
    topics.add(new SNSTopic(topic));
  }


}
