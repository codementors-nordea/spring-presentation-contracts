package pl.codementors.producer.fraud.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FraudReason {
    NO_FRAUD("No fraud detected"),
    AMOUNT_TOO_HIGH("Amount of money is too high");

    private final String message;
}
