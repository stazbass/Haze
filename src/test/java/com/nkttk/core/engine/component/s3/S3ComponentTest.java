package com.nkttk.core.engine.component.s3;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.testng.Assert.*;

public class S3ComponentTest {
    static final String TEST_BUCKET_NAME_1 = "TEST_BUCKET_NAME_1";
    @Mock
    Bucket bucketMock1;
    static final String TEST_BUCKET_NAME_2 = "TEST_BUCKET_NAME_2";
    @Mock
    Bucket bucketMock2;
    @Mock
    Function<String, Bucket> bucketFactory;

    S3Component component;

    @BeforeMethod
    public void beforeMethod(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(bucketMock1.getName()).thenReturn(TEST_BUCKET_NAME_1);
        Mockito.when(bucketFactory.apply(TEST_BUCKET_NAME_1)).thenReturn(bucketMock1);
        Mockito.when(bucketFactory.apply(TEST_BUCKET_NAME_2)).thenReturn(bucketMock2);

        component = new S3Component(bucketFactory);
    }

    @Test
    public void testAddBucket() throws Exception {
        component.addBucket(TEST_BUCKET_NAME_1);
        Optional<Bucket> bucket = component.getBucket(TEST_BUCKET_NAME_1);
        assertTrue(bucket.isPresent() && bucket.get().getName().equals(TEST_BUCKET_NAME_1));
    }

    @Test
    public void testGetBucket() throws Exception {
        component.addBucket(TEST_BUCKET_NAME_1);
        component.addBucket(TEST_BUCKET_NAME_2);
        Optional<Bucket> bucket = component.getBucket(TEST_BUCKET_NAME_1);
        assertTrue(bucket.isPresent() && bucket.get().getName().equals(TEST_BUCKET_NAME_1));
    }

}