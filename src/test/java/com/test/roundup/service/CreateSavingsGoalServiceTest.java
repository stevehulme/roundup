package com.test.roundup.service;

import com.test.roundup.util.HttpEntityGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class CreateSavingsGoalServiceTest {

    @Test
    public void test() {
        RestTemplate restTemplate =  new RestTemplate();
        HttpEntityGenerator httpHeadersGenerator = new HttpEntityGenerator();
        CreateSavingsGoalService createSavingsGoalService = new CreateSavingsGoalService(restTemplate, httpHeadersGenerator);
        String savingsGoal = createSavingsGoalService.createSavingsGoal();
        savingsGoal.codePoints();
    }

}