package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by cryptobat on 11/23/2016.
 */
public class LambdaEngineTest {
  @Test
  public void testAddLambda() throws Exception {
    LambdaEngine engine = new LambdaEngine();
    engine.addLambda("test_name", ()-> (input, context) -> {
      System.out.println(input);
      return null;
    });
    engine.runLambda("test_name", "input");
  }

  @Test
  public void testRunLambda() throws Exception {

  }

}