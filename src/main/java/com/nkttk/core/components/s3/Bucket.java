package com.nkttk.core.components.s3;

import com.nkttk.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Bucket {
  private String arn;
  private String name;
  private Map<String, BucketObject> files = new HashMap<>();

  public Bucket(String name) {
    this.name = name;
  }

  public BucketObject addFile(String key){
    BucketObject file = new BucketObject(key);
    files.put(key, file);
    return file;
  }
  public BucketObject addFile(String name, String content){
    BucketObject file = addFile(name);
    writeFileContent(name, content);
    return file;
  }
  public BucketObject addFile(String name, InputStream content){
    BucketObject file = addFile(name);
    writeFileContent(name, content);
    return file;
  }
  public String getName() {
    return name;
  }

  public void writeFileContent(String file, String content){
    writeFileContent(file, new ByteArrayInputStream(content.getBytes()));
  }

  public void writeFileContent(String name, InputStream is){
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try {
      IOUtils.copy(is, outputStream);
      getFile(name).setContent(outputStream.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("Exception writing to file ", e);
    }finally {
      try {
        outputStream.close();
        is.close();
      } catch (IOException e) {
        throw new RuntimeException("Exception writing to file ", e);
      }
    }
  }

  public BucketObject getFile(String name){
    if(!files.containsKey(name))throw new RuntimeException();
    return files.get(name);
  }

  public String getArn() {
    return arn;
  }

  public void setArn(String arn) {
    this.arn = arn;
  }
}
