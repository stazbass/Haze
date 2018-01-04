package com.nkttk.core.engine;


import com.nkttk.config.cf.resources.BucketResource;
import com.nkttk.core.engine.component.s3.S3Component;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class StackContainer {
    Function<BucketResource, S3Component> s3Factory;
    List<S3Component> s3Components;

    public StackContainer(Function<BucketResource, S3Component> s3Factory){
        this.s3Components = new LinkedList<>();
        this.s3Factory = s3Factory;
    }

    public void addS3Component(BucketResource config){
        S3Component component = s3Factory.apply(config);
        s3Components.add(component);
    }
}
