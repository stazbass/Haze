package com.nkttk.core.engine.entities;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.function.Supplier;

/**
 *
 */
public class LambdaConfig<I,O> {
  private String id;
  private String name;
  private Supplier<RequestHandler<I, O>> instanceSupplier;

  public LambdaConfig(String id, String name, Supplier<RequestHandler<I, O>> instanceSupplier) {

    this.id = id;
    this.name = name;
    this.instanceSupplier = instanceSupplier;
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

  public Supplier<RequestHandler<I, O>> getInstanceSupplier() {
    return instanceSupplier;
  }

  public void setInstanceSupplier(Supplier<RequestHandler<I, O>> instanceSupplier) {
    this.instanceSupplier = instanceSupplier;
  }
}
