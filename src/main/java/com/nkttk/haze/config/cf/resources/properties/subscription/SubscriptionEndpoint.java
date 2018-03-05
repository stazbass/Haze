package com.nkttk.haze.config.cf.resources.properties.subscription;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionEndpoint {
    @JsonProperty("Fn::GetAtt")
    private List<String> getAttributeFunctionArgs;
    private String endpointArn;

    public List<String> getGetAttributeFunctionArgs() {
        return getAttributeFunctionArgs;
    }

    public void setGetAttributeFunctionArgs(List<String> getAttributeFunctionArgs) {
        this.getAttributeFunctionArgs = getAttributeFunctionArgs;
    }

    public String getEndpointArn() {
        return endpointArn;
    }

    public void setEndpointArn(String endpointArn) {
        this.endpointArn = endpointArn;
    }

    @JsonCreator
    public SubscriptionEndpoint fromARNString(String name) {
        SubscriptionEndpoint result = new SubscriptionEndpoint();
        result.endpointArn = name;
        return result;
    }

}
