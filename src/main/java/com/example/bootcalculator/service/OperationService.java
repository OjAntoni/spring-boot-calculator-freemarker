package com.example.bootcalculator.service;

import com.example.bootcalculator.entity.Operation;
import com.example.bootcalculator.entity.User;
import com.example.bootcalculator.storage.OperationDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationService {
    private final OperationDao operationDao;

    public OperationService(@Qualifier("inMemoryOperationDao") OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public void save(Operation operation){
        operationDao.save(operation);
    }

    public List<Operation> getAll(User user){
        return operationDao.getAll(user);
    }

    public double calcResult(double num1, double num2, String operationSign){
        double result = Double.MIN_VALUE;
        switch (operationSign){
            case "sum": result = num1+num2; break;
            case "sub": result = num1-num2; break;
            case "div": result = num1/num2; break;
            case "mult": result = num1*num2; break;
        }
        return result;
    }
}
