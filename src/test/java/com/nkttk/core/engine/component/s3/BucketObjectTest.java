package com.nkttk.core.engine.component.s3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BucketObjectTest {
    private static final String BUCKET_OBJECT_KEY = "BUCKET_OBJECT_KEY";
    private BucketObject bucketObject;

    @BeforeMethod
    public void setUp() {
        bucketObject = new BucketObject(BUCKET_OBJECT_KEY);
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testGetKey() {
        assertEquals(bucketObject.getKey(), BUCKET_OBJECT_KEY);
    }

    @Test
    public void testGetContent() {
        String expectedContent = "SAMPLE_CONTENT";
        bucketObject.setContent(expectedContent);
        assertEquals(new String(bucketObject.getContent()), expectedContent);
    }

    @Test
    public void testSetContent() {
        String expectedContent = "SAMPLE_CONTENT";
        bucketObject.setContent(expectedContent);
        assertEquals(new String(bucketObject.getContent()), expectedContent);
    }

    @Test
    public void testSetContent1() {
        String expectedContent = "SAMPLE_CONTENT";
        bucketObject.setContent(expectedContent.getBytes());
        assertEquals(new String(bucketObject.getContent()), expectedContent);
    }
}