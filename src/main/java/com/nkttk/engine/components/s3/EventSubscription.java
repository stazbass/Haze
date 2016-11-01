package com.nkttk.engine.components.s3;

import com.nkttk.engine.components.events.S3Event;
import com.nkttk.engine.components.events.S3EventType;

import java.util.function.Consumer;

/**
 *
 */
public class EventSubscription {
  private String bucket;
  private S3EventType eventType;
  private Consumer<S3Event> subscriber;

  public EventSubscription(String bucket, S3EventType eventType, Consumer<S3Event> subscriber) {
    this.bucket = bucket;
    this.eventType = eventType;
    this.subscriber = subscriber;
  }

  public String getBucket() {
    return bucket;
  }

  public void setBucket(String bucket) {
    this.bucket = bucket;
  }

  public S3EventType getEventType() {
    return eventType;
  }

  public void setEventType(S3EventType eventType) {
    this.eventType = eventType;
  }

  public Consumer<S3Event> getSubscriber() {
    return subscriber;
  }

  public void setSubscriber(Consumer<S3Event> subscriber) {
    this.subscriber = subscriber;
  }
}
