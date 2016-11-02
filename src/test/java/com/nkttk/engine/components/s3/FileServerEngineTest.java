package com.nkttk.engine.components.s3;

import org.testng.annotations.Test;

/**
 *
 */
public class FileServerEngineTest {
  @Test
  public void testAddFile(){
    FileServerEngine engine = new FileServerEngine();
    String bucketName = "sample_bucket";
    engine.addBucket(bucketName);
    String fileName = "sample.txt";
    String fileContent = "bla bla bla\nbla bla\n";
    BucketObject file = engine.addFile(bucketName, fileName, fileContent);
    System.out.println(new String(file.getContent()));
  }

}