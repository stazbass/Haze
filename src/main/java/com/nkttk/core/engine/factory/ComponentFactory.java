package com.nkttk.core.engine.factory;

import com.nkttk.core.engine.ComponentStack;
import com.nkttk.core.engine.component.s3.Bucket;
import com.nkttk.core.engine.component.s3.BucketObject;
import com.nkttk.core.engine.component.s3.S3Component;

public class ComponentFactory {
    public S3Component buildClient(ComponentStack engine) {
        return new S3Component(bucketName -> new Bucket(bucketName, filename -> new BucketObject(filename)));
    }
}
