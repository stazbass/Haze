package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by cryptobat on 11/1/2016.
 */
public class LambdaInstance<I,O> {
  private String  url;
  private RequestHandler<I,O> handler;
  private String name;
  private LambdaContext context;

  public LambdaInstance(String url, String name, RequestHandler<I,O> handler){
    this.url = url;
    this.handler = handler;
    this.context = new LambdaContext(name);
  }

  public O execute(I input){
    return handler.handleRequest(input, context);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
