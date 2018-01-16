package com.nkttk.haze.engine;

import com.nkttk.haze.config.cf.CloudFormationConfig;
import com.nkttk.haze.config.cf.resources.AWSResource;
import com.nkttk.haze.config.cf.resources.BucketResource;
import com.nkttk.haze.engine.component.s3.FSContainer;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
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

        Function<BucketResource, FSContainer> s3Factory = Mockito.spy(res -> Mockito.mock(FSContainer.class));
        StackContainer container = new StackContainer(s3Factory);
        container.loadConfig(config);

    }
}