package com.example.springbootCRUD.controller;

import com.example.springbootCRUD.entity.ErrorResponse;
import com.example.springbootCRUD.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;


@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException exception){
//        System.out.println(exception);
        ErrorResponse errorResponse = new ErrorResponse(LocalTime.now(),exception.getMessage(),"product not found");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}



