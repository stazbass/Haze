package com.nkttk.haze.engine.event;

public class EventSubscription {
    private String source;
    private String destination;
    private S3NotificationType type;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public S3NotificationType getType() {
        return type;
    }

    public void setType(S3NotificationType type) {
        this.type = type;
    }
}
