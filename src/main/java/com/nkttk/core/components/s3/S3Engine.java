package com.nkttk.core.components.s3;


import com.nkttk.core.components.ComponentIdentifier;
import com.nkttk.core.components.events.BucketEvent;
import com.nkttk.core.components.events.BucketEventType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 */
public class S3Engine {
    private List<EventSubscription> eventSubscriptions = new LinkedList<>();
    private Set<Bucket> buckets;
    private Function<String, Bucket> bucketFactory;

    public S3Engine(Function<String, Bucket> bucketFactory){
        this.bucketFactory = bucketFactory;
        this.buckets = new HashSet<>();
    }

    public Bucket addBucket(String name) {
        Bucket result = bucketFactory.apply(name);
        buckets.put(name, result);
        return result;
    }

    public List<ComponentIdentifier> getIdentifiers() {
        List<ComponentIdentifier> identifiers = new LinkedList<>();
        for (String key : buckets.keySet()) {
            identifiers.add(new ComponentIdentifier(key, buckets.get(key).getUrl()));
        }
        return identifiers;
    }

    public BucketObject addFile(String bucketName, String fileName, String content) {
        return addFile(bucketName, fileName, new ByteArrayInputStream(content.getBytes()));
    }

    public BucketObject addFile(String bucketName, String fileName, InputStream content) {
        Bucket bucket = getBucket(bucketName);
        BucketObject bucketObject = bucket.addFile(fileName, content);
        eventSubscriptions.forEach(subscription -> {
            if (subscription.getEventType() == BucketEventType.PUT) {
                subscription.getHandler().accept(new BucketEvent(bucket, bucketObject, BucketEventType.PUT));
            }
        });
        return bucketObject;
    }

    public Optional<Bucket> getBucket(String name) {
        return  Optional.of(buckets.get(name));
    }

    public void addEventSubscription(Bucket bucket, BucketEventType type, Consumer<BucketEvent> subscription) {
        eventSubscriptions.add(new EventSubscription(bucket, type, subscription));
    }
}
