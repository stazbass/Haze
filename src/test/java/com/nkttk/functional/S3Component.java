package com.nkttk.functional;

import com.amazonaws.services.s3.model.S3Object;
import com.nkttk.core.engine.AWSEngine;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

public class S3Component {
    @Test
    public void testS3() throws IOException {
        AWSEngine engine = new AWSEngine();
        engine.addS3Bucket("testbucket");
        engine.addFile("testbucket", "some_file", "some_content");
        S3Object o = engine.getFile("testbucket", "some_file");
        InputStream stream = o.getObjectContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String content = br.readLine();
        Assert.assertEquals(content, "some_content");
    }


}
