package pl.codementors.consumer.loan.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class LoanRequest {

    BigDecimal amount;

    @JsonCreator
    public LoanRequest(@JsonProperty("amount") BigDecimal amount) {
        this.amount = amount;
    }
}
