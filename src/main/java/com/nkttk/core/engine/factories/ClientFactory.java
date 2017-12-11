package com.nkttk.core.engine.factories;

import com.amazonaws.services.s3.AmazonS3;
import com.nkttk.core.clients.HazeS3;
import com.nkttk.core.components.s3.S3Engine;
import com.nkttk.core.engine.ComponentContainer;

public class ClientFactory {
    public S3Engine s3Engine;

    public ClientFactory(S3Engine s3Engine){
        this.s3Engine = s3Engine;
    }



    public AmazonS3 buildS3Client(){
        return new HazeS3(s3Engine);
    }
}
