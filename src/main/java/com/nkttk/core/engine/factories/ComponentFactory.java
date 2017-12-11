package com.nkttk.core.engine.factories;

import com.nkttk.core.components.s3.S3Engine;
import com.nkttk.core.engine.ComponentContainer;

public class ComponentFactory {
    public S3Engine buildClient(ComponentContainer engine){
        return new S3Engine();
    }
}
