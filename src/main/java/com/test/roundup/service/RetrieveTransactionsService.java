package com.test.roundup.service;

import com.test.roundup.domain.transaction.Transaction;
import com.test.roundup.domain.transaction.TransactionResponse;
import com.test.roundup.util.HttpEntityGenerator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RetrieveTransactionsService {

    private final RestTemplate restTemplate;

    private final HttpEntityGenerator httpEntityGenerator;

    public RetrieveTransactionsService(RestTemplate restTemplate, HttpEntityGenerator httpEntityGenerator) {
        this.restTemplate = restTemplate;
        this.httpEntityGenerator = httpEntityGenerator;
    }

    public List<Transaction> getTransactions() {

        var httpEntity = httpEntityGenerator.createHttpHeaders();

        var rateResponse =
                restTemplate.exchange("https://api-sandbox.starlingbank.com/api/v1/transactions",
                        HttpMethod.GET, httpEntity, new ParameterizedTypeReference<TransactionResponse>() {
                        }).getBody();
        return rateResponse.getEmbeddedTransactions().getTransactions();

    }

}
