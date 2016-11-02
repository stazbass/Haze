package com.nkttk.engine.components.s3;

/**
 *
 */
public class BucketObject {
  private String key;
  private byte[] content;

  public BucketObject(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }
}
