package com.nkttk.yaml;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
public class ServerlessParserTest {
  @BeforeMethod
  public void setUp() throws Exception {

  }

  @Test
  public void testParse() throws Exception {
    ServerlessParser parser = new ServerlessParser();
    parser.parse(ServerlessParserTest.class.getClassLoader().getResourceAsStream("serverless.yml"));

  }

}