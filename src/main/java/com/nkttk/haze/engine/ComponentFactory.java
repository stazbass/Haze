package com.nkttk.haze.engine;

import com.nkttk.haze.config.cf.resources.BucketResource;
import com.nkttk.haze.engine.component.s3.Bucket;
import com.nkttk.haze.engine.component.s3.FSContainer;
import com.nkttk.haze.engine.component.s3.FileObject;

public class ComponentFactory {
    public FSContainer buildS3(BucketResource resource){
        return new FSContainer(n->new Bucket(n, obj->new FileObject(obj)));
    }
}
