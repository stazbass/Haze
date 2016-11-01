package com.nkttk.engine.components.sqs.entities;

import java.util.UUID;

/**
 */
public class SQSMessage {
  private String id;
  private String body;
  private String receiptHandle;

  public SQSMessage(String body) {
    this.id = UUID.randomUUID().toString();
    this.body = body;
  }

  public String getReceiptHandle() {
    return receiptHandle;
  }

  public void setReceiptHandle(String receiptHandle) {
    this.receiptHandle = receiptHandle;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
