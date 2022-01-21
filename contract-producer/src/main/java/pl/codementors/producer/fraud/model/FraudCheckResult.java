package pl.codementors.producer.fraud.model;

import lombok.Value;

@Value
public class FraudCheckResult {

    FraudReason reason;
    boolean isAccepted;

}
