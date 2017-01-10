package com.nkttk.config.cf.resources.properties.subscription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SNSSubscription {
  @JsonProperty("Endpoint")
  private SubscriptionEndpoint subscriptionEndpoint;
  @JsonProperty("Protocol")
  private SubscriptionProtocol protocol;

  public SubscriptionEndpoint getSubscriptionEndpoint() {
    return subscriptionEndpoint;
  }

  public void setSubscriptionEndpoint(SubscriptionEndpoint subscriptionEndpoint) {
    this.subscriptionEndpoint = subscriptionEndpoint;
  }

  public SubscriptionProtocol getProtocol() {
    return protocol;
  }

  public void setProtocol(SubscriptionProtocol protocol) {
    this.protocol = protocol;
  }
}
