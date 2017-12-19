package com.nkttk.core.engine.event;

public class Event {
    private EventType type;

    public Event(EventType type){
        this.type = type;
    }

    public EventType getType(){
        return type;
    }
}
