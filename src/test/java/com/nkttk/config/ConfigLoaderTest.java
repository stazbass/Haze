package com.nkttk.config;

import com.google.gson.Gson;
import com.nkttk.config.cf.CloudFormationConfig;
import com.nkttk.config.cf.ConfigLoader;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 */
public class ConfigLoaderTest {
  @Test
  public void testLoadConfig() throws IOException {
    CloudFormationConfig cf = ConfigLoader.loadConfig(ConfigLoaderTest.class.getClassLoader().getResourceAsStream("cf_config_sqs.json"));

    System.out.println(new Gson().toJson(cf));
  }

}