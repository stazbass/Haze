package com.nkttk.haze.engine.component.event;

import com.nkttk.haze.engine.component.s3.Bucket;
import com.nkttk.haze.engine.component.s3.FileObject;

/**
 * "s3": {
 * "configurationId": "testConfigRule",
 * "object": {
 * "eTag": "0123456789abcdef0123456789abcdef",
 * "sequencer": "0A1B2C3D4E5F678901",
 * "key": "HappyFace.jpg",
 * "size": 1024
 * },
 * "bucket": {
 * "arn": "arn:engine:s3:::mybucket",
 * "name": "sourcebucket",
 * "ownerIdentity": {
 * "principalId": "EXAMPLE"
 * }
 * },
 * "s3SchemaVersion": "1.0"
 * },
 */
public class BucketEvent {
    private Bucket bucket;
    private FileObject fileObject;
    private BucketEventType bucketEventType;

    public BucketEvent(Bucket bucket, FileObject fileObject, BucketEventType bucketEventType) {
        this.fileObject = fileObject;
        this.bucketEventType = bucketEventType;
        this.bucket = bucket;
    }


    public FileObject getFileObject() {
        return fileObject;
    }

    public BucketEventType getBucketEventType() {
        return bucketEventType;
    }

    public Bucket getBucket() {
        return bucket;
    }
}
