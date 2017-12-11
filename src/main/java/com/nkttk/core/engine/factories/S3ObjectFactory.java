package com.nkttk.core.engine.factories;

import com.amazonaws.services.s3.model.S3Object;
import com.nkttk.core.components.s3.Bucket;
import com.nkttk.core.components.s3.BucketObject;

import java.io.ByteArrayInputStream;

/**
 *
 */
public class S3ObjectFactory {
    public static S3Object buildS3Object(Bucket bucket) {
        throw new RuntimeException("NOT IMPLEMENTED");
        // S3Object s3Object = new S3Object();
//    s3Object.setKey(bucketObject.getKey());
//    s3Object.setObjectContent(new ByteArrayInputStream(bucketObject.getContent()));
//    s3Object.setBucketName(bucket);
//
// return s3Object;
    }
}
