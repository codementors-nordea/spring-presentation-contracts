package pl.codementors.producer.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FraudDetectionController {

    private final FraudService fraudService;

    @PostMapping("/check")
    FraudResponse checkFraud(@RequestBody FraudRequest fraudRequest) {
        return fraudService.checkFraud(fraudRequest);
    }
}
