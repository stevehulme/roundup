package com.test.roundup.service;

import com.test.roundup.util.HttpHeadersGenerator;
import com.test.roundup.util.UUIDGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class CreateSavingsGoalServiceTest {

    public static final String TEST_UUID = "testUUid";

    private RestTemplate restTemplate = mock(RestTemplate.class);

    private HttpHeadersGenerator httpHeadersGenerator = mock(HttpHeadersGenerator.class);

    private UUIDGenerator uuidGenerator = mock(UUIDGenerator.class);

    private CreateSavingsGoalService createSavingsGoalService;

    @BeforeEach
    public void before() {
      createSavingsGoalService = new CreateSavingsGoalService(restTemplate, httpHeadersGenerator, uuidGenerator);
    }

    @Test
    public void testCreateSavingsGoal() {

        when(uuidGenerator.getUUID()).thenReturn(TEST_UUID);
        var urlParams = new HashMap<String, String>();
        urlParams.put("savingsGoalUid", TEST_UUID);

        String savingsGoal = createSavingsGoalService.createSavingsGoal();

        verify(restTemplate).exchange(eq("https://api-sandbox.starlingbank.com/api/v1/savings-goals/{savingsGoalUid}"),
                eq(HttpMethod.PUT), any(HttpEntity.class), eq(Void.class), eq(urlParams));

        assertSame(TEST_UUID, savingsGoal);

    }
}