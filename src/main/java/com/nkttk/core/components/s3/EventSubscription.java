package com.nkttk.core.components.s3;

import com.nkttk.core.components.events.BucketEvent;
import com.nkttk.core.components.events.BucketEventType;

import java.util.function.Consumer;

/**
 *
 */
public class EventSubscription {
  private Bucket bucket;
  private BucketEventType eventType;
  private Consumer<BucketEvent> handler;

  public EventSubscription(Bucket bucket, BucketEventType eventType, Consumer<BucketEvent> handler) {
    this.bucket = bucket;
    this.eventType = eventType;
    this.handler = handler;
  }

  public Bucket getBucket() {
    return bucket;
  }

  public void setBucket(Bucket bucket) {
    this.bucket = bucket;
  }

  public BucketEventType getEventType() {
    return eventType;
  }

  public void setEventType(BucketEventType eventType) {
    this.eventType = eventType;
  }

  public Consumer<BucketEvent> getHandler() {
    return handler;
  }

  public void setHandler(Consumer<BucketEvent> handler) {
    this.handler = handler;
  }
}
