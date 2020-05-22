package com.xohotech.task.core;

import java.time.LocalDateTime;

public class HttpMessageBuilder {

    private String status;
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

    {
        this.timestamp = LocalDateTime.now();
    }

    public HttpMessageBuilder created() {
        this.status = "Created";
        this.statusCode = 201;
        return this;
    }

    public HttpMessageBuilder ok() {
        this.status = "Ok";
        this.statusCode = 200;
        return this;
    }

    public HttpMessageBuilder unauthorized() {
        this.status = "Unauthorized";
        this.statusCode = 401;
        return this;
    }

    public HttpMessageBuilder notFound() {
        this.status = "Not Found";
        this.statusCode = 404;
        return this;
    }

    public HttpMessageBuilder notModified() {
        this.status = "Not Modified";
        this.statusCode = 304;
        return this;
    }

    public HttpMessageBuilder conflicted() {
        this.status = "Resource Already Exists";
        this.statusCode = 409;
        return this;
    }

    public HttpMessageBuilder badRequest() {
        this.status = "Bad Request";
        this.statusCode = 400;
        return this;
    }

    public HttpMessageBuilder methodNotAllowed() {
        this.status = "Method Not Allowed";
        this.statusCode = 405;
        return this;
    }

    public HttpMessageBuilder internalServerError() {
        this.status = "Internal Server Error";
        this.statusCode = 500;
        return this;
    }

    public HttpMessageBuilder message(String message) {
        this.message = message;
        return this;
    }

    public HttpMessage build() {
        return new HttpMessage(this.status, this.statusCode, this.message, this.timestamp);
    }

}
