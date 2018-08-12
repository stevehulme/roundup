package com.test.roundup.service;

import com.test.roundup.domain.Currency;
import com.test.roundup.util.HttpEntityGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PutSavingsService {

    private final RestTemplate restTemplate;

    private final HttpEntityGenerator httpEntityGenerator;

    public PutSavingsService(RestTemplate restTemplate, HttpEntityGenerator httpEntityGenerator) {
        this.restTemplate = restTemplate;
        this.httpEntityGenerator = httpEntityGenerator;
    }

    public void putSavings(String savingsGoalUUID, BigDecimal roundedupAmount) {

        var httpEntity = httpEntityGenerator.createHttpHeaders();


        var param = new HashMap<String, String>();
        var uuid = UUID.randomUUID().toString();
        param.put("savingsGoalUid", savingsGoalUUID);
        param.put("transferUid", uuid);

        var currency = new Currency();
        currency.setMinorUnits(roundedupAmount);
        currency.setCurrency(java.util.Currency.getInstance("GBP"));

        var entity = new HttpEntity<>(currency, httpEntity.getHeaders());

        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange("https://api-sandbox.starlingbank.com//api/v1/savings-goals/{savingsGoalUid}/add-money/{transferUid}",
                    HttpMethod.PUT, entity, String.class, param);

        } catch (Exception e) {
            responseEntity.getBody();
            e.toString();
        }


    }
}
