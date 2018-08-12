package com.test.roundup.controller;

import com.test.roundup.service.RoundupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoundupController {

    public RoundupController(RoundupService roundupService) {
        this.roundupService = roundupService;
    }

    private final RoundupService roundupService;

    @GetMapping
    public void roundup() {
        roundupService.roundup();
    }
}
