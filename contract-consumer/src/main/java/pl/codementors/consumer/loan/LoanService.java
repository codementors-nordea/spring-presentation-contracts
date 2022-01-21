package pl.codementors.consumer.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.codementors.consumer.loan.fraud.FraudClient;
import pl.codementors.consumer.loan.fraud.FraudRequest;
import pl.codementors.consumer.loan.model.LoanRequest;
import pl.codementors.consumer.loan.model.LoanResponse;

@Component
@RequiredArgsConstructor
public class LoanService {

    private final FraudClient fraudClient;

    public LoanResponse createLoan(LoanRequest request) {
        var fraudResponse = fraudClient.checkFraud(new FraudRequest(request.getAmount()));

        if (fraudResponse.isAccepted()) {
            return LoanResponse.accept();
        }

        return LoanResponse.reject(fraudResponse.getRejectionReason());
    }
}
