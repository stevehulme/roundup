package com.test.roundup.service;

import com.test.roundup.domain.transaction.Transaction;
import com.test.roundup.domain.transaction.TransactionResponse;
import com.test.roundup.util.HttpHeadersGenerator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RetrieveTransactionsService {

    private final RestTemplate restTemplate;

    private final HttpHeadersGenerator httpHeadersGenerator;

    public RetrieveTransactionsService(RestTemplate restTemplate, HttpHeadersGenerator httpHeadersGenerator) {
        this.restTemplate = restTemplate;
        this.httpHeadersGenerator = httpHeadersGenerator;
    }

    public List<Transaction> getTransactions() {

        HttpEntity<TransactionResponse> getEntity = getHttpEntity();

        var rateResponse =
                restTemplate.exchange("https://api-sandbox.starlingbank.com/api/v1/transactions",
                        HttpMethod.GET, getEntity, new ParameterizedTypeReference<TransactionResponse>() {
                        }).getBody();
        return rateResponse.getEmbeddedTransactions().getTransactions();

    }

    private HttpEntity<TransactionResponse> getHttpEntity() {
        var httpHeaders = httpHeadersGenerator.createHttpHeaders();
        return new HttpEntity<>(httpHeaders);
    }

}
