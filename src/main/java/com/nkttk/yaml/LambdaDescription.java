package com.nkttk.yaml;

/**
 *
 */
public class LambdaDescription {
  private String handler;
  private String name;
  private String timeout;
  private String memorySize;
  private Object events;

  public LambdaDescription(String name, String handler) {
    this.name = name;
    this.handler = handler;
  }

  @Override
  public String toString() {
    return "LambdaDescription{" +
           "handler='" + handler + '\'' +
           ", name='" + name + '\'' +
           ", timeout='" + timeout + '\'' +
           ", memorySize='" + memorySize + '\'' +
           ", events=" + events +
           '}';
  }

  public String getHandler() {
    return handler;
  }

  public void setHandler(String handler) {
    this.handler = handler;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTimeout() {
    return timeout;
  }

  public void setTimeout(String timeout) {
    this.timeout = timeout;
  }

  public String getMemorySize() {
    return memorySize;
  }

  public void setMemorySize(String memorySize) {
    this.memorySize = memorySize;
  }

  public Object getEvents() {
    return events;
  }

  public void setEvents(Object events) {
    this.events = events;
  }
}
