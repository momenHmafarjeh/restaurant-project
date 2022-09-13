package com.example.Restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public HttpStatus StatusCode (){
        return HttpStatus.NOT_FOUND;

    }

}
