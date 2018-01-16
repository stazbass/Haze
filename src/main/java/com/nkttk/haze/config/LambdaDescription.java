package com.nkttk.haze.config;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.function.Supplier;

/**
 *
 */
public class LambdaDescription<I, O> {
    private Supplier<RequestHandler<I, O>> instanceSupplier;
    private String name;
    private String timeout;
    private String memorySize;
    private Object events;

    public LambdaDescription(String name, Supplier<RequestHandler<I, O>> instanceSupplier) {
        this.name = name;
        this.instanceSupplier = instanceSupplier;
    }

    @Override
    public String toString() {
        return "LambdaDescription{" +
                "handler='" + instanceSupplier + '\'' +
                ", name='" + name + '\'' +
                ", timeout='" + timeout + '\'' +
                ", memorySize='" + memorySize + '\'' +
                ", event=" + events +
                '}';
    }

    public Supplier<RequestHandler<I, O>> getInstanceSupplier() {
        return instanceSupplier;
    }

    public void setInstanceSupplier(Supplier<RequestHandler<I, O>> handler) {
        this.instanceSupplier = handler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public Object getEvents() {
        return events;
    }

    public void setEvents(Object events) {
        this.events = events;
    }
}
