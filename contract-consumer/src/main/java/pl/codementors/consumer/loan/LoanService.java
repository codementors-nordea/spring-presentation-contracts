package pl.codementors.consumer.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.codementors.consumer.loan.model.LoanRequest;
import pl.codementors.consumer.loan.model.LoanResponse;

@Component
@RequiredArgsConstructor
public class LoanService {

    public LoanResponse createLoan(LoanRequest request) {
        return LoanResponse.accept();
    }
}
