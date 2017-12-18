package com.nkttk.core.engine.component.sns;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Created by cryptobat on 11/1/2016.
 */
public class SNSTopic {
  private String name;
  private String url;
  private List<Consumer<String>> subscribers = new LinkedList<>();

  public SNSTopic(String name) {
    this.name = name;
    this.url = UUID.randomUUID().toString();
  }

  public String getUrl() {
    return url;
  }

  public void addSubscriber(Consumer<String> subscriber) {
    subscribers.add(subscriber);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void publishMessage(String message) {
    subscribers.forEach(subscriber -> subscriber.accept(message));
  }
}
