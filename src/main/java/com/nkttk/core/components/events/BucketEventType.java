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

  BucketEventType byName(String name){
    BucketEventType [] values = BucketEventType.values();
    for(int i = 0; i < values.length; i++){
      if(values[i].s3Name.equals(name)){
        return values[i];
      }
    }
    throw new RuntimeException("Bucket event type not : " + name);
  }
}
