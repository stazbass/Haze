package com.nkttk.haze.config.cf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nkttk.haze.config.cf.resources.AWSResource;

import java.util.Map;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudFormationConfig {
    @JsonProperty("Resources")
    private Map<String, AWSResource> resources;

    public Map<String, AWSResource> getResources() {
        return resources;
    }

    public void setResources(Map<String, AWSResource> resources) {
        this.resources = resources;
    }
}
