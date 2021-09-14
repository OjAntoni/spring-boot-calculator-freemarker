package com.example.bootcalculator.storage;

import com.example.bootcalculator.entity.User;

public interface UserDao {
    void save(User user);
    boolean exists(String username);
    User get(String username);
}
