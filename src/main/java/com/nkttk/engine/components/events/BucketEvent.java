package com.nkttk.engine.components.events;

import com.nkttk.engine.components.s3.BucketObject;

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
 "arn": "arn:aws:s3:::mybucket",
 "name": "sourcebucket",
 "ownerIdentity": {
 "principalId": "EXAMPLE"
 }
 },
 "s3SchemaVersion": "1.0"
 },
 */
public class BucketEvent {
  private BucketObject bucketObject;
  private BucketEventType bucketEventType;

  public BucketEvent(BucketObject bucketObject, BucketEventType bucketEventType) {
    this.bucketObject = bucketObject;
    this.bucketEventType = bucketEventType;
  }


  public BucketObject getBucketObject() {
    return bucketObject;
  }

  public void setBucketObject(BucketObject bucketObject) {
    this.bucketObject = bucketObject;
  }

  public BucketEventType getBucketEventType() {
    return bucketEventType;
  }

  public void setBucketEventType(BucketEventType bucketEventType) {
    this.bucketEventType = bucketEventType;
  }
}
