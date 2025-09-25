package com.rakib.spring.protocols.controller;

import com.rakib.spring.protocols.mock.MockRestService;
import com.rakib.spring.protocols.model.Request;
import com.rakib.spring.protocols.model.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    private MockRestService mockRestService;

    public RequestController(MockRestService mockRestService) {
        this.mockRestService = mockRestService;
    }

    @PostMapping("/transform")
    public Response transform(@RequestBody Request request) {
        String transformedMessage = "Transformed: " + request.getMessage();
        mockRestService.callEndpoint(transformedMessage);
        return new Response(transformedMessage);
    }
}
