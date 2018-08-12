package com.test.roundup.service;

import com.test.roundup.util.HttpEntityGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

class PutSavingsServiceTest {

    @Test
    public void test() {
        var restTemplate = new RestTemplate();
        var httpHeadersGenerator = new HttpEntityGenerator();
        CreateSavingsGoalService createSavingsGoalService = new CreateSavingsGoalService(restTemplate, httpHeadersGenerator);
        String savingsGoal = createSavingsGoalService.createSavingsGoal();
        var putSavingsService = new PutSavingsService(restTemplate, httpHeadersGenerator);
        putSavingsService.putSavings(savingsGoal, BigDecimal.ONE);

    }

}