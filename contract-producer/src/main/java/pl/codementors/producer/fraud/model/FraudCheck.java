package pl.codementors.producer.fraud.model;

import java.math.BigDecimal;

public class FraudCheck {

    private final BigDecimal amountOfMoney;

    public FraudCheck(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public FraudCheckResult isPotentiallyFraud() {
        if (amountOfMoney.compareTo(BigDecimal.valueOf(10_000)) > 0) {
            return new FraudCheckResult(FraudReason.AMOUNT_TOO_HIGH, false);
        }

        return new FraudCheckResult(FraudReason.NO_FRAUD, true);
    }
}
