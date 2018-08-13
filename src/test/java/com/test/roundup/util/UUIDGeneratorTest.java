package com.test.roundup.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UUIDGeneratorTest {

    private UUIDGenerator uuidGenerator = new UUIDGenerator();

    @Test
    public void shouldGenerateUUIDString() {
        String uuid = uuidGenerator.getUUID();

        assertNotNull(uuid);
    }

}