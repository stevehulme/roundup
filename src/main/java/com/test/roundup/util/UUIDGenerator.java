package com.test.roundup.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDGenerator {

    public String getUUID() {
        return UUID.randomUUID().toString();
    }
}
