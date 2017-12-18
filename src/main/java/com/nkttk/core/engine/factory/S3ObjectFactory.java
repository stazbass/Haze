package com.nkttk.core.engine.factory;

import com.amazonaws.services.s3.model.S3Object;
import com.nkttk.core.engine.component.s3.Bucket;

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
