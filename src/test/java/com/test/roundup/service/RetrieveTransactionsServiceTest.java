package com.test.roundup.service;

import com.test.roundup.util.HttpEntityGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class RetrieveTransactionsServiceTest {

    @Test
    void test1() {

        RestTemplate restTemplate =  new RestTemplate();
        HttpEntityGenerator httpHeadersGenerator = new HttpEntityGenerator();
        RetrieveTransactionsService retrieveTransactionsService = new RetrieveTransactionsService(restTemplate, httpHeadersGenerator);
        retrieveTransactionsService.getTransactions();
    }
}