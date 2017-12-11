package com.nkttk.core.engine.factories;

import com.amazonaws.services.s3.AmazonS3;
import com.nkttk.core.clients.HazeS3;
import com.nkttk.core.engine.ComponentContainer;

public class ClientFactory {
    public AmazonS3 buildS3Client(ComponentContainer engine){
        return new HazeS3(engine);
    }
}
