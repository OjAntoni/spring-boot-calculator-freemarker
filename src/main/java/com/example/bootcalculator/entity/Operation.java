package com.example.bootcalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private long id;
    private double num1;
    private double num2;
    private double result;
    private String operationSign;
    private User user;

    @Override
    public String toString() {
       return String.format("%f %s %f = %f", num1, operationSign, num2, result);
    }
}
