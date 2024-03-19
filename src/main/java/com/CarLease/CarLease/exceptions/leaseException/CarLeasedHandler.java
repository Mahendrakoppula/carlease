package com.CarLease.CarLease.exceptions.leaseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarLeasedHandler {
    @ExceptionHandler(value = CarLeasedException.class)
    public ResponseEntity<Object> handleCarLeasedException(CarLeasedException carLeasedException){

        LeaseEXception leaseException = new LeaseEXception();
        leaseException.setMessage(carLeasedException.getMessage());

        return new ResponseEntity<>(leaseException, HttpStatus.FORBIDDEN);
    }
}
