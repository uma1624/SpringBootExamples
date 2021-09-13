package com.aus.advice;

import  com.aus.advice.OrderServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class, OrderServiceException.class})
    public ResponseEntity<Object> handleException(final OrderServiceException exp) {
        System.out.println("================= Umasankar =========");
        return new ResponseEntity<Object>("order not found  " + exp.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
