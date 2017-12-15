package com.nkttk.core.components.s3;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
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
    public void testAddObject() throws Exception {
        BucketObject expectedBucketObjcet = new BucketObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);

        BucketObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME);

        Assert.assertEquals(result, expectedBucketObjcet);
    }

    @Test
    public void testAddObjectWithStringContent() throws Exception {
        BucketObject expectedBucketObjcet = new BucketObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);

        BucketObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME, TEST_OBJECT_CONTENT);

        Assert.assertEquals(new String(result.getContent()), TEST_OBJECT_CONTENT);
    }

    @Test
    public void testAddObjectWithInputStreamContent() throws Exception {
        BucketObject expectedBucketObjcet = new BucketObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);

        BucketObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME, new ByteArrayInputStream(TEST_OBJECT_CONTENT.getBytes()));

        Assert.assertEquals(new String(result.getContent()), TEST_OBJECT_CONTENT);
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals(bucket.getName(), TEST_BUCKET_NAME);
    }

    @Test
    public void testGetObject(){
        BucketObject expectedBucketObjcet = new BucketObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);
        bucket.addObject(TEST_BUCKET_OBJECT_NAME);
        BucketObject actualObject = bucket.getObject(TEST_BUCKET_OBJECT_NAME).get();
        Assert.assertEquals(actualObject, expectedBucketObjcet);
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(bucket.hashCode(), TEST_BUCKET_NAME.hashCode());
    }

    @Test
    public void testEquals() throws Exception {
        String bucketName = "some_name";
        Bucket bucketA = new Bucket(bucketName, (name)->new BucketObject(name));
        Bucket bucketB = new Bucket(bucketName, (name)->new BucketObject(name));
        Assert.assertTrue(bucketA.equals(bucketB) && bucketB.equals(bucketA));
    }
}