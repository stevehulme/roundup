package com.test.roundup.service;

import com.test.roundup.domain.savingsgoal.SavingsGoal;
import com.test.roundup.util.HttpHeadersGenerator;
import com.test.roundup.util.UUIDGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;
import java.util.HashMap;

@Service
public class CreateSavingsGoalService {

    private final RestTemplate restTemplate;

    private final HttpHeadersGenerator httpHeadersGenerator;

    private final UUIDGenerator uuidGenerator;

    public CreateSavingsGoalService(RestTemplate restTemplate,

                                    HttpHeadersGenerator httpHeadersGenerator, UUIDGenerator uuidGenerator) {
        this.restTemplate = restTemplate;
        this.httpHeadersGenerator = httpHeadersGenerator;
        this.uuidGenerator = uuidGenerator;
    }

    public String createSavingsGoal() {

        var urlParams = new HashMap<String, String>();
        String uuid = uuidGenerator.getUUID();
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
