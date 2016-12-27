package com.nkttk.config.cf.resources;

import com.nkttk.config.cf.resources.notifications.S3NotificationToSQS;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 */
public class BucketResource {
  private String bucketName;
  private List<S3NotificationToSQS> sqsNotifications = new LinkedList<>();

  public BucketResource(String bucketName, List<S3NotificationToSQS> sqsNotifications) {
    this.bucketName = bucketName;
    this.sqsNotifications = sqsNotifications;
  }

  public static BucketResource build(Map params){
    List<S3NotificationToSQS> sqsNotifications = new LinkedList<>();
    String bucketName = (String) params.get("BucketName");
    if(params.containsKey("NotificationConfiguration")){
      Map<String, ?> configuration = (Map<String, ?>) params.get("NotificationConfiguration");
      if(configuration.containsKey("QueueConfigurations")){
        Map<String, ?> queueConfigurations = (Map<String, ?>) configuration.get("QueueConfigurations");
        for(Object queueNotification : queueConfigurations.values()){
          Map<String, String> config = (Map<String, String>)queueNotification;
          sqsNotifications.add(new S3NotificationToSQS(config.get("Event"), config.get("Filter"), config.get("Queue")));
        }
      }
    }
    return new BucketResource(bucketName, sqsNotifications);
  }

  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }

  public List<S3NotificationToSQS> getSqsNotifications() {
    return sqsNotifications;
  }

  public void setSqsNotifications(List<S3NotificationToSQS> sqsNotifications) {
    this.sqsNotifications = sqsNotifications;
  }
}
