package com.nkttk.core.components.sqs;

import com.nkttk.core.components.sqs.entities.MessageLock;
import com.nkttk.core.components.sqs.entities.SQSMessage;

import java.util.*;

/**
 */
public class SQSInstance {
  private final String endpointURL;
  private final String name;
  private long messageLockInterval = 60 * 1000;
  private Collection<SQSMessage> messages = new LinkedList<>();
  private Collection<SQSMessage> hiddenMessages = new LinkedList<>();
  private Set<MessageLock> lockRecords = new HashSet<>();

  public SQSInstance(String name) {
    this.endpointURL = "http://" + UUID.randomUUID().toString();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setMessageLockInterval(long messageLockInterval) {
    this.messageLockInterval = messageLockInterval;
  }

  public void putMessage(SQSMessage message) {
    messages.add(message);
  }

  public SQSMessage getMessage() {
    unhideMessages();
    SQSMessage message = ((Queue<SQSMessage>) messages).peek();
    if (message != null) {
      hideMessage(message.getId());
      message.setReceiptHandle(UUID.randomUUID().toString());
      return message;
    }
    return null;
  }

  public void deleteMessage(String handle) {
    lockRecords.removeIf((record) -> {
      if (record.getReceiptHandler().equals(handle)) {
        hiddenMessages.removeIf((message -> message.getId().equals(record.getMessageId())));
        return true;
      }
      return false;
    });
  }

  public String getEndpointURL() {
    return endpointURL;
  }

  private void unhideMessages() {
    lockRecords.removeIf(lock -> {
      if (lock.getStartedAt() + lock.getLength() < System.currentTimeMillis()) {
        unhideMessage(lock.getMessageId());
        return true;
      }
      return false;
    });
  }

  private void unhideMessage(String id) {
    hiddenMessages.removeIf(hiddenMessage -> {
      if (hiddenMessage.getId().equals(id)) {
        messages.add(hiddenMessage);
        hiddenMessage.setReceiptHandle(null);
        return true;
      }
      return false;
    });
  }

  private void hideMessage(String id) {
    messages.removeIf(message -> {
      if (message.getId().equals(id)) {
        hiddenMessages.add(message);
        MessageLock lock = new MessageLock(message.getId(), System.currentTimeMillis(), messageLockInterval);
        message.setReceiptHandle(lock.getReceiptHandler());
        lockRecords.add(lock);
        return true;
      }
      return false;
    });
  }
}
