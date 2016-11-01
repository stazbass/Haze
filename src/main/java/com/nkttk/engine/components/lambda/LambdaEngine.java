package com.nkttk.engine.components.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cryptobat on 11/1/2016.
 */
public class LambdaEngine {
  private List<LambdaInstance> instances = new LinkedList<>();

  public <I,O> void addLambda(String url, String name, RequestHandler<I,O> handler){
    this.instances.add(new LambdaInstance(url, name, handler));
  }

  public Object runLambda(String name, Object arg){
    for(LambdaInstance instance : instances){
      if(instance.getName().equals(name))return instance.execute(arg);
    }
    throw new RuntimeException("Lambda function not defined: " + name);
  }
}
