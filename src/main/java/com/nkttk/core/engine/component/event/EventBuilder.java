package com.nkttk.core.engine.component.event;

import com.amazonaws.services.s3.event.S3EventNotification;

import java.util.Arrays;

/**
 * Sample event time : "1970-01-01T00:00:00.000Z"
 */
public class EventBuilder {
  public static final String EVENT_SOURCE_S3 = "engine:s3";

  public static final S3EventNotification buildS3Notification(BucketEventType type, String bucketName, String bucketArn, String fileName, int fileSize, String eTag) {
    S3EventNotification.S3ObjectEntity objectEntity = new S3EventNotification.S3ObjectEntity(fileName, fileSize, eTag, "1");
    S3EventNotification.S3BucketEntity bucket = new S3EventNotification.S3BucketEntity(bucketName, null, bucketArn);
    S3EventNotification.S3Entity s3Entity = new S3EventNotification.S3Entity("testConfigRule", bucket, objectEntity, "1");
    S3EventNotification.RequestParametersEntity requestParametersEntity = new S3EventNotification.RequestParametersEntity("127.0.0.1");
    S3EventNotification.ResponseElementsEntity responseElementsEntity = new S3EventNotification.ResponseElementsEntity("EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH", "EXAMPLE123456789");
    S3EventNotification.S3EventNotificationRecord records =
        new S3EventNotification.S3EventNotificationRecord("",
                                                          type.getS3Name(),
                                                          EVENT_SOURCE_S3,
                                                          "1970-01-01T00:00:00.000Z",
                                                          "1",
                                                          requestParametersEntity,
                                                          responseElementsEntity, s3Entity, null);
    S3EventNotification notification = new S3EventNotification(Arrays.asList(records));
    return notification;
  }
}
