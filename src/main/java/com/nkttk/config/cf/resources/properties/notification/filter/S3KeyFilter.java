package com.nkttk.config.cf.resources.properties.notification.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 */
public class S3KeyFilter {
    @JsonProperty("Rules")
    private List<FilterRule> rules;

    public List<FilterRule> getRules() {
        return rules;
    }

    public void setRules(List<FilterRule> rules) {
        this.rules = rules;
    }
}
