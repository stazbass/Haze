package com.nkttk.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nkttk.config.cf.CloudFormationConfig;
import com.nkttk.config.cf.ConfigLoader;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 */
public class ConfigLoaderTest {
  @Test
  public void testLoadConfig() throws IOException {
    CloudFormationConfig cf = ConfigLoader.loadConfig(ConfigLoaderTest.class.getClassLoader().getResourceAsStream("cf/sample_cf_config.json"));
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.setPrettyPrinting().create();
    System.out.println(gson.toJson(cf));
  }

}