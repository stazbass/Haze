package com.nkttk.config;

/**
 *
 */
public class SQSDescription {
  private String name;

  public SQSDescription(String name) {

    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "SQSDescription{" +
           "name='" + name + '\'' +
           '}';
  }
}
