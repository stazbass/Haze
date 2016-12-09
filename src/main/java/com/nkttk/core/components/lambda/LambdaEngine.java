package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.nkttk.json.JsonMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaEngine {
  private static final Logger LOGGER = LoggerFactory.getLogger(LambdaEngine.class);
  private LambdaBuilder lambdaBuilder;

  public LambdaEngine(LambdaBuilder lambdaBuilder){
    this.lambdaBuilder = lambdaBuilder;
  }

  public ByteBuffer runLambda(String name, ByteBuffer arg) throws IOException, ClassNotFoundException {
    RequestHandler<?,?> requestHandler = (RequestHandler<?,?>)lambdaBuilder.getProduceFunction().apply(name);
    if(name != null){
      return execute(name, arg, requestHandler);
    }else{
      throw new RuntimeException("No function found : " + name);
    }
  }

  public <I,O> ByteBuffer execute(String name, ByteBuffer input, RequestHandler<I,O> requestHandler) throws IOException, ClassNotFoundException {
    String arg = new String(input.array());
    TypeReference<I> typeReference =  new TypeReference<I>() {};
    I argumentDeserialized = (I)deserializer(requestHandler).apply(arg);
    LambdaContext context = new LambdaContext(name);
    O result = requestHandler.handleRequest(argumentDeserialized, context);
    LOGGER.debug("Running lambda {} with args {} \n Result: \n {}", name, argumentDeserialized, result);
    return ByteBuffer.wrap(JsonMaster.toString(result).getBytes());
  }

  private Function<String, Object> deserializer(RequestHandler requestHandler) throws ClassNotFoundException {
    for (Method method : requestHandler.getClass().getDeclaredMethods()) {
      if(method.getName().equals("handleRequest")){
        Type argType = getArgumentType(requestHandler);
        if(argType instanceof ParameterizedType){
          ParameterizedType firstArgumentType = (ParameterizedType )argType;
          Class<?> rawClass = Class.forName(firstArgumentType.getRawType().getTypeName());
          if(Collection.class.isAssignableFrom(rawClass)){
            return getGenericCollectionDeserializer(firstArgumentType);
          }
        }
        return getPlainDeserializer(JsonMaster.om().getTypeFactory().constructType(argType));
      }
    }
    throw new RuntimeException("Can't find appropriate deserialzier ");
  }

  private Function<String, Object> getPlainDeserializer(JavaType valueType) {
    return serialized -> {
      try {
        return JsonMaster.om().readValue(serialized, valueType);
      } catch (IOException e) {
        throw new RuntimeException("Deserialization exception ", e);
      }
    };
  }

  private Function<String, Object> getGenericCollectionDeserializer(ParameterizedType type) throws
                                                                                            ClassNotFoundException {
    Type[] typeParams = type.getActualTypeArguments();
    Class<?>[] genericParamClasses = new Class[typeParams.length];
    for(int i = 0; i < typeParams.length; i++){
      genericParamClasses[i] = Class.forName(typeParams[i].getTypeName());
    }
    JavaType javaType = JsonMaster.om().getTypeFactory().constructParametrizedType(ArrayList.class, Collection.class, genericParamClasses);
    return getPlainDeserializer(javaType);
  }

  private Type getArgumentType(RequestHandler requestHandler){
    for (Method method : requestHandler.getClass().getDeclaredMethods()) {
      if (method.getName().equals("handleRequest")) {
        Type[] argumentTypes = method.getGenericParameterTypes();
        if(!argumentTypes[0].getTypeName().contains(Object.class.getName())){
          return argumentTypes[0];
        }
      }
    }
    throw new RuntimeException("Request handler argument type not found");
  }
}
