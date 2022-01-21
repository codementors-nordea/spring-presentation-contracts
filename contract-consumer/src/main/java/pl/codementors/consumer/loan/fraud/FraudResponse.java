package pl.codementors.consumer.loan.fraud;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.Objects;

@Value
public class FraudResponse {
    String rejectionReason;

    @JsonCreator
    public FraudResponse(@JsonProperty("rejectionReason") String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public boolean isAccepted() {
        return Objects.isNull(rejectionReason) || rejectionReason.isEmpty();
    }
}
