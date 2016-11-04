package com.nkttk.core.components.events;

public enum BucketEventType {
  PUT("ObjectCreated:Put");

  BucketEventType(String name){
    this.s3Name = name;
  }
  String s3Name;

  public String getS3Name(){
    return this.s3Name;
  }
}
