package com.test.roundup.service;

import com.test.roundup.domain.transaction.EmbeddedTransactions;
import com.test.roundup.domain.transaction.Transaction;
import com.test.roundup.domain.transaction.TransactionResponse;
import com.test.roundup.util.HttpHeadersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RetrieveTransactionsServiceTest {

    private RestTemplate restTemplate = mock(RestTemplate.class);

    private HttpHeadersGenerator httpHeadersGenerator = mock(HttpHeadersGenerator.class);

    private RetrieveTransactionsService retrieveTransactionsService;

    @BeforeEach
    public void before() {
        retrieveTransactionsService = new RetrieveTransactionsService(restTemplate, httpHeadersGenerator);
    }

    @Test
    public void shouldRetrieveTransactions() {

        ResponseEntity responseEntity = mock(ResponseEntity.class);
        TransactionResponse transactionResponse = mock(TransactionResponse.class);
        EmbeddedTransactions embeddedTransactions = mock(EmbeddedTransactions.class);
        Transaction transaction = mock(Transaction.class);
        when(embeddedTransactions.getTransactions()).thenReturn(List.of(transaction));
        when(transactionResponse.getEmbeddedTransactions()).thenReturn(embeddedTransactions);
        when(responseEntity.getBody()).thenReturn(transactionResponse);
        when(restTemplate.exchange(eq("https://api-sandbox.starlingbank.com/api/v1/transactions"),
                eq(HttpMethod.GET), any(HttpEntity.class), any(ParameterizedTypeReference.class))).thenReturn(responseEntity);

        List<Transaction> transactions = retrieveTransactionsService.getTransactions();

        assertEquals(List.of(transaction), transactions);
    }
}