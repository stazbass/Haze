package com.nkttk.haze.engine.component.s3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileObjectTest {
    private static final String BUCKET_OBJECT_KEY = "BUCKET_OBJECT_KEY";
    private FileObject fileObject;

    @BeforeMethod
    public void setUp() {
        fileObject = new FileObject(BUCKET_OBJECT_KEY);
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testGetKey() {
        assertEquals(fileObject.getKey(), BUCKET_OBJECT_KEY);
    }

    @Test
    public void testGetContent() {
        String expectedContent = "SAMPLE_CONTENT";
        fileObject.setContent(expectedContent);
        assertEquals(new String(fileObject.getContent()), expectedContent);
    }

    @Test
    public void testSetContent() {
        String expectedContent = "SAMPLE_CONTENT";
        fileObject.setContent(expectedContent);
        assertEquals(new String(fileObject.getContent()), expectedContent);
    }

    @Test
    public void testSetContent1() {
        String expectedContent = "SAMPLE_CONTENT";
        fileObject.setContent(expectedContent.getBytes());
        assertEquals(new String(fileObject.getContent()), expectedContent);
    }
}