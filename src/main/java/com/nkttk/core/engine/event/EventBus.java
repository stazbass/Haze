package com.nkttk.core.engine.event;


import java.util.LinkedList;
import java.util.List;

/**
 * Class for management event exchange process
 */
public class EventBus {
    private List<IEventDispatcher> dispatchers;
    private List<IEventListener> listeners;

    public EventBus(){
        this.listeners = new LinkedList<>();
        this.dispatchers = new LinkedList<>();
    }

    public void registerListener(IEventListener listener){
        listeners.add(listener);
    }

    public void registerDispatcher(IEventDispatcher dispatcher){
        dispatcher.registerCallback((event)->{
            listeners.stream().forEach(l->l.handleEvent(event));
        });
    }
}
