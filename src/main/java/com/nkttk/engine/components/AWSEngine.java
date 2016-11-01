package com.nkttk.engine.components;

import com.google.gson.Gson;
import com.nkttk.engine.components.events.S3Event;
import com.nkttk.engine.components.lambda.LambdaEngine;
import com.nkttk.engine.components.s3.FileServerEngine;
import com.nkttk.engine.components.sns.SNSEngine;
import com.nkttk.engine.components.sqs.SQSEngine;
import com.nkttk.engine.components.sqs.SQSInstance;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AWSEngine {
  private SQSEngine sqsEngine;
  private FileServerEngine fileServerEngine;
  private SNSEngine snsEngine;
  private LambdaEngine lambdaEngine;
  private Map<String, String> s3EventSQSSubscribers = new LinkedHashMap<>();
  private Map<String, String> scheduledEventLambdaSubscribers = new LinkedHashMap<>();

  public AWSEngine(){
    this.sqsEngine = new SQSEngine();
    this.fileServerEngine = new FileServerEngine();
    this.snsEngine = new SNSEngine();
    this.lambdaEngine = new LambdaEngine();
  }

  public void addSQS(String url){
    sqsEngine.addInstance(new SQSInstance(url));
  }

  public void addSNS(String url){
    snsEngine.addTopic(url);
  }

  public void subscribeSQSToS3Event(String eventType, String sqsUrl){
    s3EventSQSSubscribers.put(eventType, sqsUrl);
  }

  public void addBucket(String name){

  }

  public void dispatchS3Event(S3Event event){
    s3EventSQSSubscribers.values().forEach(url->sqsEngine.sendMessage(url, new Gson().toJson(event)));
  }

  public void runLambda(String name, Object args){
    lambdaEngine.runLambda(name, args);
  }
}
