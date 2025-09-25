package com.rakib.spring.protocols.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MockRestServiceTest {

    @Mock
    private RestClient restClient;

    @Mock
    private RestClient.Builder restClientBuilder;

    @Mock
    private MockServer mockServer;

    @InjectMocks
    private MockRestService mockRestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(restClientBuilder.baseUrl(any(URI.class))).thenReturn(restClientBuilder);
        when(restClientBuilder.build()).thenReturn(restClient);
        mockRestService = new MockRestService(restClientBuilder, mockServer);
    }

    @Test
    public void testCallEndpoint() {
        // Given
        String message = "Test Message";
        String expectedResponse = "OK";

        // When
        RestClient.RequestBodyUriSpec requestBodyUriSpec = org.mockito.Mockito.mock(RestClient.RequestBodyUriSpec.class);
        when(restClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri("/external")).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.contentType(MediaType.APPLICATION_JSON)).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.header(any(), any())).thenReturn(requestBodyUriSpec);

        RestClient.ResponseSpec responseSpec = org.mockito.Mockito.mock(RestClient.ResponseSpec.class);
        when(requestBodyUriSpec.body(any(String.class))).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.body(String.class)).thenReturn(expectedResponse);

        String response = mockRestService.callEndpoint(message);

        // Then
        assertEquals(expectedResponse, response);
    }
}
