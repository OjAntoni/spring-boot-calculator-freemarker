package com.example.bootcalculator.storage.inMemoryDao;

import com.example.bootcalculator.entity.Operation;
import com.example.bootcalculator.entity.User;
import com.example.bootcalculator.storage.OperationDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryOperationDao implements OperationDao {
    private static final List<Operation> operations = new ArrayList<>();

    @Override
    public void save(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> getAll(User user) {
        return new ArrayList<>(operations);
    }
}
