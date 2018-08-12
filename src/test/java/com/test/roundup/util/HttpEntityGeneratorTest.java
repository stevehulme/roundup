package com.test.roundup.util;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HttpEntityGeneratorTest {

    @Test
    public void shouldCreateHttpEntity() {
        HttpEntityGenerator httpEntityGenerator = new HttpEntityGenerator();

        HttpEntity<String> httpHeaders = httpEntityGenerator.createHttpHeaders();

        assertEquals(httpHeaders.getHeaders().getAccept(), List.of(MediaType.APPLICATION_JSON));
        assertEquals(httpHeaders.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertNotNull(httpHeaders.getHeaders().get("Authorization"));
    }

}