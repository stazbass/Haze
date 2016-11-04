package com.nkttk.core.components.events;

import com.nkttk.core.components.s3.Bucket;
import com.nkttk.core.components.s3.BucketObject;

/**
 "s3": {
 "configurationId": "testConfigRule",
 "object": {
 "eTag": "0123456789abcdef0123456789abcdef",
 "sequencer": "0A1B2C3D4E5F678901",
 "key": "HappyFace.jpg",
 "size": 1024
 },
 "bucket": {
 "arn": "arn:engine:s3:::mybucket",
 "name": "sourcebucket",
 "ownerIdentity": {
 "principalId": "EXAMPLE"
 }
 },
 "s3SchemaVersion": "1.0"
 },
 */
public class BucketEvent {
  private Bucket bucket;
  private BucketObject bucketObject;
  private BucketEventType bucketEventType;

  public BucketEvent(Bucket bucket, BucketObject bucketObject, BucketEventType bucketEventType) {
    this.bucketObject = bucketObject;
    this.bucketEventType = bucketEventType;
    this.bucket = bucket;
  }


  public BucketObject getBucketObject() {
    return bucketObject;
  }

  public BucketEventType getBucketEventType() {
    return bucketEventType;
  }

  public Bucket getBucket() {
    return bucket;
  }
}
