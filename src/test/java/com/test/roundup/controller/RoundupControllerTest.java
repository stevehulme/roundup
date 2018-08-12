package com.test.roundup.controller;

import com.test.roundup.service.RoundupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoundupControllerTest {

    private RoundupService roundupService = mock(RoundupService.class);

    RoundupController roundupController;

    @BeforeEach
    public void before() {
        roundupController = new RoundupController(roundupService);
    }

    @Test
    public void shouldCallRoundupService() {

        roundupController.roundup();

        verify(roundupService).roundup();
    }

}