package com.nkttk.engine.components.events;

import com.amazonaws.services.s3.event.S3EventNotification;

/**
 * Sample event time : "1970-01-01T00:00:00.000Z"
 */
public class EventBuilder {
  public static final String EVENT_SOURCE_S3 = "aws:s3";
  private static Long sequencer = 1;

  public static final S3EventNotification buildS3Notification(BucketEventType type, String buckerUrl, fileName ) {
    S3EventNotification.S3BucketEntity bucket = new S3EventNotification.S3BucketEntity()
    S3EventNotification.S3Entity s3Entity = new S3EventNotification.S3Entity("testConfigRule", )
    S3EventNotification.RequestParametersEntity requestParametersEntity = new S3EventNotification.RequestParametersEntity("127.0.0.1");
    S3EventNotification.ResponseElementsEntity responseElementsEntity = new S3EventNotification.ResponseElementsEntity("EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH", "EXAMPLE123456789");
    S3EventNotification.S3EventNotificationRecord records =
        new S3EventNotification.S3EventNotificationRecord("",
                                                          type.getS3Name(),
                                                          EVENT_SOURCE_S3,
                                                          "1970-01-01T00:00:00.000Z",
                                                          "1",
                                                          requestParametersEntity,
                                                          responseElementsEntity,

                                                          );
    S3EventNotification notification = new S3EventNotification()
  }
}
