package pl.codementors.consumer.loan.model;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanResponse {

    LoanResult result;
    String reason;

    public static LoanResponse accept() {
        return new LoanResponse(LoanResult.ACCEPTED, "");
    }

    public static LoanResponse reject(String reason) {
        return new LoanResponse(LoanResult.REJECTED, reason);
    }
}
