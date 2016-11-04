package com.nkttk.core.components.s3;

import java.util.UUID;

/**
 *
 */
public class BucketObject {
  private String etag;
  private String key;
  private byte[] content;

  public BucketObject(String key) {
    this.key = key;
    this.etag = UUID.randomUUID().toString();
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public int getSize(){
    return content.length;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public String getEtag() {
    return etag;
  }

  public void setEtag(String etag) {
    this.etag = etag;
  }
}
