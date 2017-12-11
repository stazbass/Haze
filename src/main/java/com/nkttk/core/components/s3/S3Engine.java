package com.nkttk.core.components.s3;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Facade for S3 component related logic into component container. Container for buckets, bucket event subscriptions
 */
public class S3Engine {
    private List<Bucket> buckets;
    private Function<String, Bucket> bucketFactory;

    public S3Engine(Function<String, Bucket> bucketFactory) {
        this.bucketFactory = bucketFactory;
        this.buckets = new LinkedList<>();
    }

    public Bucket addBucket(String name) {
        Bucket result = bucketFactory.apply(name);
        buckets.add(result);
        return result;
    }

    public BucketObject addFile(String bucketName, String fileName, String content) {
        return addFile(bucketName, fileName, new ByteArrayInputStream(content.getBytes()));
    }

    public BucketObject addFile(String bucketName, String fileName, InputStream content) {
        Bucket bucket = getBucket(bucketName).orElseThrow(() -> new RuntimeException("Bucket not found : " + bucketName));
        BucketObject bucketObject = bucket.addObject(fileName, content);
        return bucketObject;
    }

    public Optional<Bucket> getBucket(String name) {
        return buckets.stream().filter(o -> o.getName().equals(name)).findFirst();
    }
}
