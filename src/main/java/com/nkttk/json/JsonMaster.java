package com.nkttk.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 *
 */
public class JsonMaster {
  public static ObjectMapper om() {
    return objectMapper;
  }

  private static ObjectMapper objectMapper = new ObjectMapper();
  public static <T> T readValue(String content, Class<T> valueType)
      throws IOException
  {
    return objectMapper.readValue(content, valueType);
  }

  public static <T> T readValue(String content, TypeReference valueTypeRef) throws IOException {
    return objectMapper.readValue(content, valueTypeRef);
  }

  public static String toString(Object object){
    try {
      return new String(objectMapper.writeValueAsBytes(object));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new RuntimeException("Deserialization failed ", e);
    }
  }

}
