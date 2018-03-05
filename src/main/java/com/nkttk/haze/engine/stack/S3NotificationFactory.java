package com.nkttk.haze.engine.stack;

import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.nkttk.haze.engine.event.S3Notification;

public class S3NotificationFactory {
    S3Notification buildNotification(NotificationConfiguration type, String data) {
        return new S3Notification(type, data);
    }
}
