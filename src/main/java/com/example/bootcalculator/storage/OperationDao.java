package com.example.bootcalculator.storage;

import com.example.bootcalculator.entity.Operation;
import com.example.bootcalculator.entity.User;

import java.util.List;

public interface OperationDao {
    void save(Operation operation);
    List<Operation> getAll(User user);
}
