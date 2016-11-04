package com.nkttk.core.components.sns.entities;

/**
 * Created by cryptobat on 11/1/2016.
 */
public class SNSMessage {
  private String body;

  public SNSMessage(String body) {
    this.body = body;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
