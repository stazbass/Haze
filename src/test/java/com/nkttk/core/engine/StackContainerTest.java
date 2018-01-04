package com.nkttk.core.engine;

import com.nkttk.config.cf.CloudFormationConfig;
import com.nkttk.config.cf.ConfigParser;
import com.nkttk.config.cf.resources.AWSResource;
import com.nkttk.config.cf.resources.BucketResource;
import com.nkttk.core.engine.component.s3.S3Component;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class StackContainerTest {
    Map<String, AWSResource> resources;
    @Mock
    BucketResource mockBucketConfig;
    @Mock
    CloudFormationConfig config;
    @Mock
    Map<String, AWSResource> mockResources;
    @Mock
    BucketResource bucketResource;


    @BeforeMethod
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
        resources = new HashMap<>();
        resources.put("test_bucket_res", mockBucketConfig);
    }

    @Test
    public void testConfigLoading() throws IOException {

        Function<BucketResource, S3Component> s3Factory = Mockito.spy(res -> Mockito.mock(S3Component.class));
        StackContainer container = new StackContainer(s3Factory);
        container.loadConfig(config);

    }
}