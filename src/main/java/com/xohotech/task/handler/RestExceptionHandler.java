package com.xohotech.task.handler;

import com.xohotech.task.core.*;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<HttpMessage> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new HttpMessageBuilder().notFound().message(ex.getMessage()).build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ResourceAlreadyExistsException.class)
    protected ResponseEntity<HttpMessage> handleResourceAlreadyExists(ResourceAlreadyExistsException ex) {
        return new ResponseEntity<>(new HttpMessageBuilder().conflicted().message(ex.getMessage()).build(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = BadRequestException.class)
    protected ResponseEntity<HttpMessage> handleBadRequest(BadRequestException ex) {
        return new ResponseEntity<>(new HttpMessageBuilder().badRequest().message(ex.getMessage()).build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UnauthorizedAccessException.class)
    protected ResponseEntity<HttpMessage> handleUnauthorizedAccess(UnauthorizedAccessException ex) {
        return new ResponseEntity<>(new HttpMessageBuilder().unauthorized().message(ex.getMessage()).build(),
                HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new HttpMessageBuilder().methodNotAllowed().build(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new HttpMessageBuilder().badRequest().build(), HttpStatus.BAD_REQUEST);
    }
}

