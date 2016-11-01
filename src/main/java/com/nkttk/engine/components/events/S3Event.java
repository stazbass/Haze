package com.nkttk.engine.components.events;

/**
 "s3": {
 "configurationId": "testConfigRule",
 "object": {
 "eTag": "0123456789abcdef0123456789abcdef",
 "sequencer": "0A1B2C3D4E5F678901",
 "key": "HappyFace.jpg",
 "size": 1024
 },
 "bucket": {
 "arn": "arn:aws:s3:::mybucket",
 "name": "sourcebucket",
 "ownerIdentity": {
 "principalId": "EXAMPLE"
 }
 },
 "s3SchemaVersion": "1.0"
 },
 */
public class S3Event {
  private String etag;
  private String sequencer;
  private String key;
  private String size;

  public S3Event(String etag, String sequencer, String key, String size) {
    this.etag = etag;
    this.sequencer = sequencer;
    this.key = key;
    this.size = size;
  }
}
