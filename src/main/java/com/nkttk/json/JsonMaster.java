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
  private static ObjectMapper om = new ObjectMapper();
  public static <T> T readValue(String content, Class<T> valueType)
      throws IOException, JsonParseException, JsonMappingException
  {
    // !!! TODO
    //    	_setupClassLoaderForDeserialization(valueType);
    return om.readValue(content, valueType);
  }

  public static <T> T readValue(String content, TypeReference valueTypeRef) throws IOException {
    return om.readValue(content, valueTypeRef);
  }

  public static String toString(Object object){
//    ByteArrayOutputStream bos = new ByteArrayOutputStream();
//    try {
//      ;
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    try {
      return new String(om.writeValueAsBytes(object));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new RuntimeException("Deserialization failed ", e);
    }
  }

}
