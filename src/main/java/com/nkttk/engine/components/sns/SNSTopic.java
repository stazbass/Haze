package com.nkttk.engine.components.sns;

import com.nkttk.engine.components.sns.entities.SNSMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by cryptobat on 11/1/2016.
 */
public class SNSTopic {
  private String name;
  private List<Consumer<SNSMessage>> subscribers = new LinkedList<>();

  public SNSTopic(String name) {
    this.name = name;
  }

  public void addSubscriber(Consumer<SNSMessage> subscriber){
    subscribers.add(subscriber);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void publishMessage(SNSMessage message){
    subscribers.forEach(subscriber->subscriber.accept(message));
  }
}
