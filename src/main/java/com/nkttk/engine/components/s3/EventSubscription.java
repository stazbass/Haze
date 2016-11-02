package com.nkttk.engine.components.s3;

import com.nkttk.engine.components.events.BucketEvent;
import com.nkttk.engine.components.events.BucketEventType;

import java.util.function.Consumer;

/**
 *
 */
public class EventSubscription {
  private String bucket;
  private BucketEventType eventType;
  private Consumer<BucketEvent> subscriber;

  public EventSubscription(String bucket, BucketEventType eventType, Consumer<BucketEvent> subscriber) {
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

  public BucketEventType getEventType() {
    return eventType;
  }

  public void setEventType(BucketEventType eventType) {
    this.eventType = eventType;
  }

  public Consumer<BucketEvent> getSubscriber() {
    return subscriber;
  }

  public void setSubscriber(Consumer<BucketEvent> subscriber) {
    this.subscriber = subscriber;
  }
}
