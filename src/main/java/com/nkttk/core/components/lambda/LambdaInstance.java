package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.nkttk.json.JsonMaster;

import java.io.IOException;
import java.nio.ByteBuffer;
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

  public ByteBuffer execute(ByteBuffer input) throws IOException {
    String arg = new String(input.array());
    I argumentDeserialized = JsonMaster.readValue(arg, new TypeReference<I>() {});
    RequestHandler<I,O> instance = this.instanceSupplier.get();
    O result = instance.handleRequest(argumentDeserialized, context);
    return ByteBuffer.wrap(JsonMaster.toString(result).getBytes());
  }

  public String getName() {
    return name;
  }
}
