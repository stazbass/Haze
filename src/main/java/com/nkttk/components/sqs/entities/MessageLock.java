package com.nkttk.components.sqs.entities;

import java.util.UUID;

/**
 */
public class MessageLock {
  private String messageId;
  private String receiptHandler;
  private long startedAt;
  private long length;

  public MessageLock(String messageId, long startedAt, long length) {
    this.messageId = messageId;
    this.startedAt = startedAt;
    this.length = length;
    this.receiptHandler = UUID.randomUUID().toString();
  }

  public String getReceiptHandler() {
    return receiptHandler;
  }

  public long getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(long startedAt) {
    this.startedAt = startedAt;
  }

  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  @Override
  public int hashCode() {
    return messageId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MessageLock that = (MessageLock) o;

    return messageId.equals(that.messageId);

  }
}
