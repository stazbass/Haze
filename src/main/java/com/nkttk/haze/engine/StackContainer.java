package com.nkttk.haze.engine;


import com.nkttk.haze.config.cf.resources.BucketResource;
import com.nkttk.haze.engine.component.s3.FSContainer;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class StackContainer {
    Function<BucketResource, FSContainer> s3Factory;
    List<FSContainer> FSContainers;

    public StackContainer(Function<BucketResource, FSContainer> s3Factory){
        this.FSContainers = new LinkedList<>();
        this.s3Factory = s3Factory;
    }

    public void addS3Component(BucketResource config){
        FSContainer component = s3Factory.apply(config);
        FSContainers.add(component);
    }
}
