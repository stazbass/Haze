package com.nkttk.haze.engine.component.s3;

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
    private Function<String, FileObject> objectFactory;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bucket = new Bucket(TEST_BUCKET_NAME, objectFactory);
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testAddObject() {
        FileObject expectedBucketObjcet = new FileObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);

        FileObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME);

        Assert.assertEquals(result, expectedBucketObjcet);
    }

    @Test
    public void testAddObjectWithStringContent() {
        FileObject expectedBucketObjcet = new FileObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);

        FileObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME, TEST_OBJECT_CONTENT);

        Assert.assertEquals(new String(result.getContent()), TEST_OBJECT_CONTENT);
    }

    @Test
    public void testAddObjectWithInputStreamContent() {
        FileObject expectedBucketObjcet = new FileObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);

        FileObject result = bucket.addObject(TEST_BUCKET_OBJECT_NAME, new ByteArrayInputStream(TEST_OBJECT_CONTENT.getBytes()));

        Assert.assertEquals(new String(result.getContent()), TEST_OBJECT_CONTENT);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(bucket.getName(), TEST_BUCKET_NAME);
    }

    @Test
    public void testGetObject(){
        FileObject expectedBucketObjcet = new FileObject(TEST_BUCKET_OBJECT_NAME);
        Mockito.when(objectFactory.apply(Mockito.anyString())).thenReturn(expectedBucketObjcet);
        bucket.addObject(TEST_BUCKET_OBJECT_NAME);
        FileObject actualObject = bucket.getObject(TEST_BUCKET_OBJECT_NAME).get();
        Assert.assertEquals(actualObject, expectedBucketObjcet);
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(bucket.hashCode(), TEST_BUCKET_NAME.hashCode());
    }

    @Test
    public void testEquals() {
        String bucketName = "some_name";
        Bucket bucketA = new Bucket(bucketName, (name)->new FileObject(name));
        Bucket bucketB = new Bucket(bucketName, (name)->new FileObject(name));
        Assert.assertTrue(bucketA.equals(bucketB) && bucketB.equals(bucketA));
    }
}