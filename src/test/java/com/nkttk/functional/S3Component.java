package com.nkttk.functional;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.nkttk.core.engine.ComponentContainer;
import com.nkttk.core.engine.factories.ClientFactory;
import com.nkttk.core.engine.factories.ComponentFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

public class S3Component {
    @Test
    public void testS3() throws IOException {
        ClientFactory clientFactory = new ClientFactory();
        ComponentFactory componentFactory = new ComponentFactory();
        ComponentContainer engine = new ComponentContainer(componentFactory, clientFactory);
        AmazonS3 s3Client = engine.getS3Client();
        s3Client.createBucket("testbucket");
        engine.addFile("testbucket", "some_file", "some_content");
        S3Object o = engine.getFile("testbucket", "some_file");
        InputStream stream = o.getObjectContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String content = br.readLine();
        Assert.assertEquals(content, "some_content");
    }


}
