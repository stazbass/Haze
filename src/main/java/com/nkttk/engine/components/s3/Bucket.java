package com.nkttk.engine.components.s3;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Bucket {
  private String name;
  private List<BucketObject> files = new LinkedList<>();

  public Bucket(String name) {
    this.name = name;
  }

  public void addFile(String key, byte [] content){
    files.add(new BucketObject(key, content));
  }

  public String getName() {
    return name;
  }
}
