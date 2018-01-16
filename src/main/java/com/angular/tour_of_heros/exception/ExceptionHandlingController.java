package com.angular.tour_of_heros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(HeroNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(HeroNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMsg(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}