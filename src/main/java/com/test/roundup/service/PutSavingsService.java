package com.test.roundup.service;

import com.test.roundup.domain.addmoney.AddMoney;
import com.test.roundup.domain.addmoney.Amount;
import com.test.roundup.util.HttpHeadersGenerator;
import com.test.roundup.util.UUIDGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;

@Service
public class PutSavingsService {

    private final RestTemplate restTemplate;

    private final HttpHeadersGenerator httpHeadersGenerator;

    private final UUIDGenerator uuidGenerator;

    public PutSavingsService(RestTemplate restTemplate, HttpHeadersGenerator httpHeadersGenerator, UUIDGenerator uuidGenerator) {
        this.restTemplate = restTemplate;
        this.httpHeadersGenerator = httpHeadersGenerator;
        this.uuidGenerator = uuidGenerator;
    }

    public void putSavings(String savingsGoalUUID, BigDecimal roundedupAmount) {

        var urlParams = new HashMap<String, String>();
        var uuid = uuidGenerator.getUUID();
        urlParams.put("savingsGoalUid", savingsGoalUUID);
        urlParams.put("transferUid", uuid);

        HttpEntity<AddMoney> putEntity = getHttpEntity(roundedupAmount);

        restTemplate.exchange("https://api-sandbox.starlingbank.com//api/v1/savings-goals/{savingsGoalUid}/add-money/{transferUid}",
                HttpMethod.PUT, putEntity, String.class, urlParams);
    }

    private HttpEntity<AddMoney> getHttpEntity(BigDecimal roundedupAmount) {

        var httpHeaders = httpHeadersGenerator.createHttpHeaders();

        var amount = new Amount();
        amount.setMinorUnits(roundedupAmount);
        amount.setCurrency(Currency.getInstance("GBP"));

        var addMoney = new AddMoney();
        addMoney.setAmount(amount);

        return new HttpEntity<>(addMoney, httpHeaders);
    }
}
