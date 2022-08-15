package com.example.Restaurant.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<ErrorDetails>  exceptionhandler (ResourceNotFoundException ex, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),request.getDescription(false));

        return new  ResponseEntity<> (errorDetails,ex.StatusCode());

    }



}
