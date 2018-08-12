package com.test.roundup.service;

import com.test.roundup.util.HttpHeadersGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class RetrieveTransactionsServiceTest {

    @Test
    void test1() {

        RestTemplate restTemplate =  new RestTemplate();
        HttpHeadersGenerator httpHeadersGenerator = new HttpHeadersGenerator();
        RetrieveTransactionsService retrieveTransactionsService = new RetrieveTransactionsService(restTemplate, httpHeadersGenerator);
        retrieveTransactionsService.getTransactions();
    }
}