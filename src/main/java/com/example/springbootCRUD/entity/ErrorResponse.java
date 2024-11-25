package com.example.springbootCRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse {
    private LocalTime localTime;
    private String message;
    private String details;

}
