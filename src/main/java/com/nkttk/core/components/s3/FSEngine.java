package com.nkttk.core.components.s3;


import com.nkttk.core.components.events.BucketEvent;
import com.nkttk.core.components.events.BucketEventType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 */
public class FSEngine {
  private List<EventSubscription> eventSubscriptions = new LinkedList<>();
  private Map<String, Bucket> buckets = new HashMap<>();

  public Bucket addBucket(String name){
    Bucket result = new Bucket(name);
    buckets.put(name, result);
    return result;
  }

  public BucketObject addFile(String bucketName, String fileName, String content){
    Bucket bucket = getBucket(bucketName);
    BucketObject bucketObject = bucket.addFile(fileName, content);
    eventSubscriptions.forEach(subscription->{
      if(subscription.getEventType() == BucketEventType.PUT){
        subscription.getHandler().accept(new BucketEvent(bucket, bucketObject, BucketEventType.PUT));
      }
    });
    return bucketObject;
  }

  public Bucket getBucket(String name){
    if(!buckets.containsKey(name))throw new RuntimeException("Bucket not found : " + name);
    return buckets.get(name);
  }

  public void addEventSubscription(Bucket bucket, BucketEventType type, Consumer<BucketEvent> subscription){
    eventSubscriptions.add(new EventSubscription(bucket, type, subscription));
  }
}
