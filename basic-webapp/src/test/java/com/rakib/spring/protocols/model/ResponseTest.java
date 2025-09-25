package com.rakib.spring.protocols.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseTest {

    @Test
    public void testConstructorAndGetTransformedMessage() {
        // Given
        String transformedMessage = "Test Message";

        // When
        Response response = new Response(transformedMessage);

        // Then
        assertEquals(transformedMessage, response.getTransformedMessage());
    }
}
