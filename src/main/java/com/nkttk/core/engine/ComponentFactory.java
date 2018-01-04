package com.nkttk.core.engine;

import com.nkttk.config.cf.resources.BucketResource;
import com.nkttk.core.engine.component.s3.Bucket;
import com.nkttk.core.engine.component.s3.BucketObject;
import com.nkttk.core.engine.component.s3.S3Component;

public class ComponentFactory {
    public S3Component buildS3(BucketResource resource){
        return new S3Component(n->new Bucket(n, obj->new BucketObject(obj)));
    }
}
