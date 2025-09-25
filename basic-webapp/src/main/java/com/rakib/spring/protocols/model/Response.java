package com.rakib.spring.protocols.model;

public class Response {
    private String transformedMessage;

    public Response(String transformedMessage) {
        this.transformedMessage = transformedMessage;
    }

    public String getTransformedMessage() {
        return transformedMessage;
    }

    public void setTransformedMessage(String transformedMessage) {
        this.transformedMessage = transformedMessage;
    }
}
