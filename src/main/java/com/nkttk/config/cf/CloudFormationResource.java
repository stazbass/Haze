package com.nkttk.config.cf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Container to read cloudformation configuration info into
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudFormationResource {
    @JsonProperty("Type")
    private ResourceType type;
    @JsonProperty("Properties")
    private Map<String, Object> properties;

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public Map<String, ?> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
