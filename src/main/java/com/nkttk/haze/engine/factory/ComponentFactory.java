package com.nkttk.haze.engine.factory;

import com.nkttk.haze.engine.ComponentStack;
import com.nkttk.haze.engine.component.s3.Bucket;
import com.nkttk.haze.engine.component.s3.FSContainer;
import com.nkttk.haze.engine.component.s3.FileObject;

public class ComponentFactory {
    public FSContainer buildClient(ComponentStack engine) {
        return new FSContainer(bucketName -> new Bucket(bucketName, filename -> new FileObject(filename)));
    }
}
