package com.nkttk.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nkttk.config.cf.CloudFormation;
import com.nkttk.config.cf.ConfigLoader;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 */
public class ConfigLoaderTest {
  @Test
  public void test_load_config() throws IOException {
    CloudFormation cf = ConfigLoader.loadConfig(ConfigLoaderTest.class.getClassLoader().getResourceAsStream("cf_config_sqs.json"));

    System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(cf));
  }

}