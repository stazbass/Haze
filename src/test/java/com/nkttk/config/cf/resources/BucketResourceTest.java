package com.nkttk.config.cf.resources;

import com.nkttk.config.ConfigLoaderTest;
import com.nkttk.config.cf.CloudFormationConfig;
import com.nkttk.config.cf.CloudFormationResource;
import com.nkttk.config.cf.ConfigLoader;
import com.nkttk.config.cf.ResourceType;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 */
public class BucketResourceTest {
  @Test
  public void testBuild() throws Exception {
    CloudFormationConfig cf = ConfigLoader.loadConfig(ConfigLoaderTest.class.getClassLoader().getResourceAsStream("cf/sample_cf_config.json"));
    List<CloudFormationResource> resourceDescriptions = cf.getResources(ResourceType.BUCKET);
    BucketResource resource = BucketResource.build(resourceDescriptions.get(0).getProperties());
    System.out.println(resource.getBucketName());
    assertEquals(resource.getBucketName(), "ods_bucket");
    System.out.println(resource.getSqsNotifications());
  }

}