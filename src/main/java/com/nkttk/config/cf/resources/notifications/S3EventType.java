package com.nkttk.config.cf.resources.notifications;

/**
 */
public enum S3EventType {
  OBJECTCREATED_PUT("s3:ObjectCreated:Put");

  private String name;

  S3EventType(String name){
     this.name = name;
  }

  static S3EventType fromString(String eventTypeName){
    for(int i = 0; i < S3EventType.values().length; i++){
      if(S3EventType.values()[i].name.equals(eventTypeName))
        return S3EventType.values()[i];
    }
    throw new RuntimeException("Unknown event type " + eventTypeName);
  }

}
