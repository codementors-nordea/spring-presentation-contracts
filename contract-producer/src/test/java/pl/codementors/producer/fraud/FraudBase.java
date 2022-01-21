package pl.codementors.producer.fraud;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@ExtendWith(MockitoExtension.class)
public class FraudBase {


    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new FraudDetectionController(new FraudService()));
    }

}