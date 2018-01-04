package com.nkttk.core.engine.event;

public class Event {
    private EventType type;
    private String data;

    public Event(EventType type, String data) {
        this.type = type;
        this.data = data;
    }

    public EventType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
