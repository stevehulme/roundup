package com.test.roundup.service;

import com.test.roundup.domain.savingsgoal.SavingsGoal;
import com.test.roundup.util.HttpHeadersGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;
import java.util.HashMap;
import java.util.UUID;

@Service
public class CreateSavingsGoalService {

    private final RestTemplate restTemplate;

    private final HttpHeadersGenerator httpHeadersGenerator;

    public CreateSavingsGoalService(RestTemplate restTemplate, HttpHeadersGenerator httpHeadersGenerator) {
        this.restTemplate = restTemplate;
        this.httpHeadersGenerator = httpHeadersGenerator;
    }

    public String createSavingsGoal() {

        var urlParams = new HashMap<String, String>();
        String uuid = UUID.randomUUID().toString();
        urlParams.put("savingsGoalUid", uuid);

        HttpEntity<SavingsGoal> putEntity = getHttpEntity();

        restTemplate.exchange("https://api-sandbox.starlingbank.com/api/v1/savings-goals/{savingsGoalUid}",
                HttpMethod.PUT, putEntity, Void.class, urlParams);

        return uuid;

    }

    private HttpEntity<SavingsGoal> getHttpEntity() {

        var httpHeaders = httpHeadersGenerator.createHttpHeaders();

        SavingsGoal savingsGoal = new SavingsGoal();
        savingsGoal.setName("test");
        savingsGoal.setCurrency(Currency.getInstance("GBP"));

        return new HttpEntity<>(savingsGoal, httpHeaders);
    }
}
