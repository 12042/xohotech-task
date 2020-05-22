package com.xohotech.task.core;

import java.time.LocalDateTime;

public class HttpMessage {

    private String status;
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

    public HttpMessage() {

    }

    public HttpMessage(String status, int statusCode, String message, LocalDateTime timestamp) {
        this.status = status;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}