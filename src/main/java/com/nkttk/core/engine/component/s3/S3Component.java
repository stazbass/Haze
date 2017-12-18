package com.nkttk.core.engine.component.s3;


import java.util.*;
import java.util.function.Function;

/**
 * Facade for S3 component related logic into component container. Container for buckets, bucket event subscriptions
 */
public class S3Component {
    private Set<Bucket> buckets;
    private Function<String, Bucket> bucketFactory;

    public S3Component(Function<String, Bucket> bucketFactory) {
        this.bucketFactory = bucketFactory;
        this.buckets = new HashSet<>();
    }

    public Bucket addBucket(String name) {
        Bucket result = bucketFactory.apply(name);
        buckets.add(result);
        return result;
    }

    public Optional<Bucket> getBucket(String name) {
        return buckets.stream().filter(o -> o.getName().equals(name)).findFirst();
    }
}
