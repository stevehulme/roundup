package com.test.roundup.service;

import com.test.roundup.domain.savingsgoal.SavingsGoal;
import com.test.roundup.util.HttpEntityGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;
import java.util.HashMap;
import java.util.UUID;

@Service
public class CreateSavingsGoalService {

    private final RestTemplate restTemplate;

    private final HttpEntityGenerator httpEntityGenerator;

    public CreateSavingsGoalService(RestTemplate restTemplate, HttpEntityGenerator httpEntityGenerator) {
        this.restTemplate = restTemplate;
        this.httpEntityGenerator = httpEntityGenerator;
    }

    public String createSavingsGoal() {
        var httpEntity = httpEntityGenerator.createHttpHeaders();

        var param = new HashMap<String, String>();
        String uuid = UUID.randomUUID().toString();
        param.put("savingsGoalUid",uuid);

        SavingsGoal savingsGoal = new SavingsGoal();
        savingsGoal.setName("test");
        savingsGoal.setCurrency(Currency.getInstance("GBP"));

        var entity = new HttpEntity<>(savingsGoal, httpEntity.getHeaders());

        ResponseEntity<Void> responseEntity =  restTemplate.exchange("https://api-sandbox.starlingbank.com/api/v1/savings-goals/{savingsGoalUid}",
                HttpMethod.PUT, entity, Void.class, param);

        return uuid;

    }
}
