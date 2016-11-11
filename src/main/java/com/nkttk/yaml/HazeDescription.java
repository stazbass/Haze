package com.nkttk.yaml;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class HazeDescription {
  private List<LambdaDescription> functions = new LinkedList<>();
  private List<SQSDescription> queueServices = new LinkedList<>();
  private List<SNSDescription> notificationServices = new LinkedList<>();
  private List<String> buckets = new LinkedList<>();

  public HazeDescription() {

  }

  public List<String> getBuckets() {
    return buckets;
  }

  public void addBucket(String name) {
    buckets.add(name);
  }

  public List<LambdaDescription> getFunctions() {
    return functions;
  }

  public List<SQSDescription> getQueueServices() {
    return queueServices;
  }

  public List<SNSDescription> getNotificationServices() {
    return notificationServices;
  }

  public void addLambda(String name, String handler) {
    functions.add(new LambdaDescription(name, handler));
  }

  public void addQueue(String name) {
    queueServices.add(new SQSDescription(name));
  }

  public void addSNS(String topic) {
    notificationServices.add(new SNSDescription(topic));
  }

  @Override
  public String toString() {
    return "HazeDescription{" +
           "functions=" + functions +
           ", queueServices=" + queueServices +
           ", notificationServices=" + notificationServices +
           ", buckets=" + buckets +
           '}';
  }
}
