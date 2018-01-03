package com.nkttk.config.cf.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.config.cf.resources.properties.BucketProperties;

/**
 */
public class BucketResource extends AWSResource {
    @JsonProperty("Properties")
    private BucketProperties properties;

    public BucketProperties getProperties() {
        return properties;
    }

    public void setProperties(BucketProperties properties) {
        this.properties = properties;
    }
}
