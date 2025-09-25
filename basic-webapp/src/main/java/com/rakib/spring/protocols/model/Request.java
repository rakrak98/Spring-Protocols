package com.rakib.spring.protocols.model;

public class Request {
    private String message;

    public Request() {
    }

    public Request(String testMessage) {
        this.message = testMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
