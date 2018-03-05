package com.nkttk.haze.engine.factory;

import com.amazonaws.services.s3.AmazonS3;
import com.nkttk.haze.client.HazeS3;
import com.nkttk.haze.engine.component.s3.FSContainer;

public class ClientFactory {
    public FSContainer FSContainer;

    public ClientFactory(FSContainer FSContainer) {
        this.FSContainer = FSContainer;
    }

    public AmazonS3 buildS3Client() {
        return new HazeS3(FSContainer);
    }
}
