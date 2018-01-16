package com.nkttk.haze.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nkttk.haze.config.cf.CloudFormationConfig;
import com.nkttk.haze.config.cf.ConfigParser;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 */
public class ConfigParserTest {
  @Test
  public void testLoadConfig() throws IOException {
    CloudFormationConfig cf = new ConfigParser().loadConfig(ConfigParserTest.class.getClassLoader().getResourceAsStream("cf/sample_cf_config.json"));
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.setPrettyPrinting().create();
    System.out.println(gson.toJson(cf));
  }

}
