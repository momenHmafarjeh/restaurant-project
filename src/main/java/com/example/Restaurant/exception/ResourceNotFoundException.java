package com.example.Restaurant.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public HttpStatus StatusCode (){
        return HttpStatus.NOT_FOUND;

    }
}
