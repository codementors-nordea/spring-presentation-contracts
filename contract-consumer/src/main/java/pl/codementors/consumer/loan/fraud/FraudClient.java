package pl.codementors.consumer.loan.fraud;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FraudClient {

    private final RestTemplate fraudClient;

    public FraudClient(RestTemplateBuilder builder) {
        this.fraudClient = builder
                .rootUri("http://localhost:10001")
                .build();
    }

    public FraudResponse checkFraud(FraudRequest fraudRequest) {
        return fraudClient.postForObject("/check", fraudRequest, FraudResponse.class);
    }
}
