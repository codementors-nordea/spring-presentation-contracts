package pl.codementors.consumer.loan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.codementors.consumer.loan.model.LoanRequest;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"pl.codementors:contract-producer:0.0.1-SNAPSHOT:stubs"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL, minPort = 10001, maxPort = 10001)
class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_reject_load_when_fraud_was_detected() throws Exception {
        // given
        var givenAmount = BigDecimal.valueOf(15000);
        var givenRequest = new LoanRequest(givenAmount);

        // when & then
        mockMvc.perform(
                post("/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(givenRequest))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value("REJECTED"))
                .andExpect(jsonPath("reason").value("Amount of money is too high"));
    }
}