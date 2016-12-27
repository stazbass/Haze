package com.nkttk.config.cf.resources;

import java.util.Map;

public class LambdaResource {
  private String name;
  private String handler;

  public LambdaResource(String name, String handler){
    this.name = name;
    this.handler = handler;
  }

  public static LambdaResource build(Map params){
    String handler = (String) params.get("Handler");
    String name = (String)params.get("FunctionName");
    return new LambdaResource(name, handler);
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
