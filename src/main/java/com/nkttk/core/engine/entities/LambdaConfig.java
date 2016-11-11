package com.nkttk.core.engine.entities;

/**
 *
 */
public class LambdaConfig {
  private String id;
  private String name;
  private String handler;

  public LambdaConfig(String id, String name, String handler) {

    this.id = id;
    this.name = name;
    this.handler = handler;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHandler() {
    return handler;
  }

  public void setHandler(String handler) {
    this.handler = handler;
  }
}
