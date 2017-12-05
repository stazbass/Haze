package com.nkttk.core.components.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.function.Function;

/**
 */
public class LambdaBuilder {
    private Function<String, RequestHandler<?, ?>> produceFunction;


    public Function<String, RequestHandler<?, ?>> getProduceFunction() {
        return produceFunction;
    }

    public void setProduceFunction(Function<String, RequestHandler<?, ?>> produceFunction) {
        this.produceFunction = produceFunction;
    }
}
