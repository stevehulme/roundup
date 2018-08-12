package com.test.roundup.service;

import com.test.roundup.util.HttpHeadersGenerator;
import com.test.roundup.util.UUIDGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PutSavingsServiceTest {


    public static final String TRANSFER_UUID = "transferUUID";
    public static final String SAVINGS_GOAL_UUID = "savingsGoalUid";

    private RestTemplate restTemplate = mock(RestTemplate.class);

    private HttpHeadersGenerator httpHeadersGenerator = mock(HttpHeadersGenerator.class);

    private UUIDGenerator uuidGenerator = mock(UUIDGenerator.class);

    private PutSavingsService putSavingsService;

    @BeforeEach
    public void before() {
        putSavingsService = new PutSavingsService(restTemplate, httpHeadersGenerator, uuidGenerator);
    }

    @Test
    public void shouldCreateSavingsService() {

        when(uuidGenerator.getUUID()).thenReturn(TRANSFER_UUID);
        var urlParams = new HashMap<String, String>();

        urlParams.put("savingsGoalUid", SAVINGS_GOAL_UUID);
        urlParams.put("transferUid", TRANSFER_UUID);

        putSavingsService.putSavings(SAVINGS_GOAL_UUID, BigDecimal.TEN);

        verify(restTemplate).exchange(eq("https://api-sandbox.starlingbank.com//api/v1/savings-goals/{savingsGoalUid}/add-money/{transferUid}"),
                eq(HttpMethod.PUT), any(HttpEntity.class), eq(String.class), eq(urlParams));

    }
}