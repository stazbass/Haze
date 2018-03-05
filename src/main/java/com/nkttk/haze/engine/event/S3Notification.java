package com.nkttk.haze.engine.event;

import com.amazonaws.services.s3.model.NotificationConfiguration;

/**
 * {
 "Records":[
 {
 "eventVersion":"2.0",
 "eventSource":"aws:s3",
 "awsRegion":"us-west-2",
 "eventTime":"2018-01-12T07:18:42.160Z",
 "eventName":"ObjectCreated:Put",
 "userIdentity":{
    "principalId":"A1RU2IIRXP0JUA"
 },
 "requestParameters":{
    "sourceIPAddress":"62.221.62.119"
 },
 "responseElements":{
    "x-amz-request-id":"699ACC4F419EE1D2",
    "x-amz-id-2":"6ZuFp16kcRcwGN4DmuGCfolYBKkuhzN01gtgrT3+6k5pZhvlwZM8XY35BDcQI3+QqssVYBTKCaM="
 },
 "s3":{
     "s3SchemaVersion":"1.0",
     "configurationId":"Put",
     "bucket":{
     "name":"stazbass",
     "ownerIdentity":{
        "principalId":"A1RU2IIRXP0JUA"
     },
        "arn":"arn:aws:s3:::stazbass"
     },
     "object":{
         "key":"IKOHA.png",
         "size":222,
         "eTag":"a504f28846ad34f596a18161a18c18e9",
         "sequencer":"005A586152193B338A"
     }
 }
 }
 ]
 }
 */
public class S3Notification {
    private NotificationConfiguration configuration;
    private String data;

    public S3Notification(NotificationConfiguration type, String data) {
        this.configuration = type;
        this.data = data;
    }

    public NotificationConfiguration getType() {
        return configuration;
    }

    public String getData() {
        return data;
    }
}
