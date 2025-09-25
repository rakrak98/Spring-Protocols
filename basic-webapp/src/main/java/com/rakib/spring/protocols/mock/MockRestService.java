package com.rakib.spring.protocols.mock;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MockRestService {
    private RestClient restClient;
    private String url;

    public MockRestService(RestClient.Builder builder, MockServer mockServer) {
        String url = mockServer.getURL();
        builder.baseUrl(url);
        this.url = url;
        this.restClient = builder.build();
    }

    public String callEndpoint(String message) {
        String requestBodyJson = "{\"message\": \"" + message + "\"}";

        String response = restClient
                .post()
                .uri("/external")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .body(requestBodyJson)
                .retrieve()
                .body(String.class);
        return response;
    }
}
