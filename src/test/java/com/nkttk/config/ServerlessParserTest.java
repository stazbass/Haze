package com.nkttk.config;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
public class ServerlessParserTest {
  @BeforeMethod
  public void setUp() {

  }

  @Test
  public void testParse() {
    ServerlessParser parser = new ServerlessParser();
    parser.parse(ServerlessParserTest.class.getClassLoader().getResourceAsStream("serverless.yml"));

  }

}