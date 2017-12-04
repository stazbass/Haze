package com.nkttk.config.cf.resources.notifications;

public class S3NotificationToSQS {
  private S3EventType event;
  private String filter;
  private String queue;

  public S3NotificationToSQS(String event, String filter, String queue) {
    this.setEvent(event);
    this.filter = filter;
    this.queue = queue;
  }

  public S3EventType getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = S3EventType.fromString(event);
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public String getQueue() {
    return queue;
  }

  public void setQueue(String queue) {
    this.queue = queue;
  }

  @Override
  public String toString() {
    return "S3NotificationToSQS{" +
           "event='" + event + '\'' +
           ", filter='" + filter + '\'' +
           ", queue='" + queue + '\'' +
           '}';
  }
}
