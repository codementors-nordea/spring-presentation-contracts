package pl.codementors.producer.fraud;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class FraudRequest {
    private final BigDecimal value;

    @JsonCreator
    public FraudRequest(@JsonProperty("value") BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
