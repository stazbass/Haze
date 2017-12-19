package com.nkttk.core.engine.event;

import java.util.function.Consumer;

@FunctionalInterface
public interface IEventDispatcher {
    void registerCallback(Consumer<Event> eventConsumer);
}
