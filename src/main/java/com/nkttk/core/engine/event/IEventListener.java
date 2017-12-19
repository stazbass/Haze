package com.nkttk.core.engine.event;

@FunctionalInterface
public interface IEventListener {
    void handleEvent(Event event);
}
