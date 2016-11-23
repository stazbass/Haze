package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class LambdaEngine {
  private List<LambdaInstance> instances = new LinkedList<>();

  public <I,O> void addLambda(String name, Supplier<? extends RequestHandler<I,O>> instanceSupplier){
    this.instances.add(new LambdaInstance(name, instanceSupplier));
  }

  public <I,O> O runLambda(String name, I arg){
    for(LambdaInstance instance : instances){
      if(instance.getName().equals(name))return (O)instance.execute(arg);
    }
    throw new RuntimeException("Lambda function not defined: " + name);
  }
}
