package com.nkttk.config.cf.resources;

import com.nkttk.config.ConfigLoaderTest;
import com.nkttk.config.cf.CloudFormationConfig;
import com.nkttk.config.cf.CloudFormationResource;
import com.nkttk.config.cf.ConfigLoader;
import com.nkttk.config.cf.ResourceType;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

/**
 */
public class LambdaResourceTest {
  @Test
  public void test_config_parsing() throws IOException {
    CloudFormationConfig cf = ConfigLoader.loadConfig(ConfigLoaderTest.class.getClassLoader().getResourceAsStream("cf/sample_cf_config.json"));
    List<CloudFormationResource> resourceDescriptions = cf.getResources(ResourceType.LAMBDA);
    LambdaResource resource = LambdaResource.build(resourceDescriptions.get(0).getProperties());
    assertEquals(resource.getName(), "processor-dev");
    assertEquals(resource.getHandler(), "com.meteogroup.observation.processor.infrastructure.aws.lambda.ProcessorRequestHandler");
  }
}