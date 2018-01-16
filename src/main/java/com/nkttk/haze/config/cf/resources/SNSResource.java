package com.nkttk.haze.config.cf.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.haze.config.cf.resources.properties.SNSProperties;

/**
 */
public class SNSResource extends AWSResource {
    @JsonProperty("Properties")
    private SNSProperties properties;

    public SNSProperties getProperties() {
        return properties;
    }

    public void setProperties(SNSProperties properties) {
        this.properties = properties;
    }
}
