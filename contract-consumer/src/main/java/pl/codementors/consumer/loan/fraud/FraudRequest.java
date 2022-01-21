package pl.codementors.consumer.loan.fraud;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class FraudRequest {

    BigDecimal value;

}
