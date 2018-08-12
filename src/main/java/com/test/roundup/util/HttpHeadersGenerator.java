package com.test.roundup.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HttpHeadersGenerator {

    public HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer 1G39qVg78VxYGBqtpKgcupJjg5MvzLF1n4h0BAYuzTSmgvsw11cyh00DM4X5jZbB");
        return headers;
    }
}
