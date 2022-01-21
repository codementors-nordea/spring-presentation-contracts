package pl.codementors.producer.fraud;

import org.springframework.stereotype.Component;
import pl.codementors.producer.fraud.model.FraudCheck;

@Component
public class FraudService {
    FraudResponse checkFraud(FraudRequest request) {
        var check = new FraudCheck(request.getValue());
        var result = check.isPotentiallyFraud();

        if (result.isAccepted()) {
            return new FraudResponse("");
        }

        return new FraudResponse(result.getReason().getMessage());
    }
}
