package com.nkttk.core.components.s3;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.function.Function;

public class BucketTest {
    private Bucket bucket;
    private static final String TEST_BUCKET_NAME = "TEST_BUCKET_NAME";
    private static final String TEST_BUCKET_OBJECT_NAME = "TEST_BUCKET_OBJECT_NAME";
    private static final String TEST_OBJECT_CONTENT = "'< --- test_object_Content --- >'";

    @Mock
    private Function<String, BucketObject> objectFactory;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bucket = new Bucket(TEST_BUCKET_NAME, objectFactory);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddFile() throws Exception {
        BucketObject expectedBucketObjcet = new BucketObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);
        BucketObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME);
        Assert.assertEquals(result, expectedBucketObjcet);
    }

    @Test
    public void testAddFile1() throws Exception {
        BucketObject expectedBucketObjcet = new BucketObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);
        BucketObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME, TEST_OBJECT_CONTENT);
        Assert.assertEquals(result.getContent(), TEST_OBJECT_CONTENT);
    }

    @Test
    public void testAddFile2() throws Exception {
    }

    @Test
    public void testGetName() throws Exception {
    }

    @Test
    public void testWriteFileContent() throws Exception {
    }

    @Test
    public void testWriteFileContent1() throws Exception {
    }

    @Test
    public void testGetFile() throws Exception {
    }

    @Test
    public void testGetUrl() throws Exception {
    }

    @Test
    public void testSetUrl() throws Exception {
    }

    @Test
    public void testHashCode() throws Exception {
    }

    @Test
    public void testEquals() throws Exception {
    }

    @Test
    public void testToString() throws Exception {
    }
}