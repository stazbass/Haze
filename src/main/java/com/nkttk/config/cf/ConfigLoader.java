package com.nkttk.config.cf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nkttk.config.cf.CloudFormation;

import java.io.IOException;
import java.io.InputStream;

/**
 */
public class ConfigLoader {
  private static ObjectMapper objectMapper = new ObjectMapper();

  public static CloudFormation loadConfig(InputStream source) throws IOException {
    CloudFormation cf = objectMapper.readValue(source, CloudFormation.class);
    return cf;
  }
}
