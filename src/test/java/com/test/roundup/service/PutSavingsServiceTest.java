package com.test.roundup.service;

import com.test.roundup.util.HttpHeadersGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

class PutSavingsServiceTest {

    @Test
    public void test() {
        var restTemplate = new RestTemplate();
        var httpHeadersGenerator = new HttpHeadersGenerator();
        var createSavingsGoalService = new CreateSavingsGoalService(restTemplate, httpHeadersGenerator);
        var savingsGoal = createSavingsGoalService.createSavingsGoal();
        var putSavingsService = new PutSavingsService(restTemplate, httpHeadersGenerator);
        putSavingsService.putSavings(savingsGoal, BigDecimal.ONE);

    }

}