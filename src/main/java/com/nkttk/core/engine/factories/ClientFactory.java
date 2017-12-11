package com.nkttk.core.engine.factories;

import com.amazonaws.services.s3.AmazonS3;
import com.nkttk.core.clients.HazeS3;
import com.nkttk.core.components.s3.S3Component;

public class ClientFactory {
    public S3Component s3Component;

    public ClientFactory(S3Component s3Component){
        this.s3Component = s3Component;
    }



    public AmazonS3 buildS3Client(){
        return new HazeS3(s3Component);
    }
}
