package com.rakib.spring.protocols.controller;

import com.rakib.spring.protocols.mock.MockRestService;
import com.rakib.spring.protocols.model.Request;
import com.rakib.spring.protocols.model.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class RequestControllerTest {

    @Mock
    private MockRestService mockRestService;

    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testTransform() {
        // Given
        Request request = new Request("Test Message");

        // When
        Response response = requestController.transform(request);

        // Then
        String expectedMessage = "Transformed: Test Message";
        assertEquals(expectedMessage, response.getTransformedMessage());
        verify(mockRestService).callEndpoint(expectedMessage);
    }
}
