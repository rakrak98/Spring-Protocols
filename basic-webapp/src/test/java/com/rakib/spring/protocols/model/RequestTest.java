package com.rakib.spring.protocols.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {

    @Test
    public void testGetAndSetMessage() {
        // Given
        Request request = new Request();
        String message = "Test Message";

        // When
        request.setMessage(message);

        // Then
        assertEquals(message, request.getMessage());
    }
}
