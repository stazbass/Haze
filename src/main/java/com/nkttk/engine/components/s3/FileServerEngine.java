package com.nkttk.engine.components.s3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class FileServerEngine {
  private List<EventSubscription> eventSubscriptions = new LinkedList<>();
  private List<Bucket> buckets = new LinkedList<>();



  public void putToFile(InputStream is, String bucket, String file){
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    br.read()
  }

  private Bucket getBucket(String name){
    for(Bucket bucket : buckets){
      if(bucket.getName().equals(name))return bucket;
    }
    return null;
  }
}
