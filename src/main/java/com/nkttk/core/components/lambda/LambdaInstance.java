package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.UUID;
import java.util.function.Supplier;

public class LambdaInstance<I,O> {
  private Supplier<RequestHandler<I, O>> instanceSupplier;
  private String name;
  private LambdaContext context;

  public LambdaInstance(String name, Supplier<RequestHandler<I, O>> instanceSupplier){
    this.instanceSupplier = instanceSupplier;
    this.context = new LambdaContext(name);
    this.name = name;
  }

  public O execute(I input){
    RequestHandler<I,O> instance = this.instanceSupplier.get();
    return instance.handleRequest(input, context);
  }

  public String getName() {
    return name;
  }
}
