package com.example.bootcalculator.service;

import com.example.bootcalculator.entity.User;
import com.example.bootcalculator.storage.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private UserDao userDao;

    public UserService(@Qualifier("inMemoryUserDao")UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user){
        userDao.save(user);
    }

    public boolean exists(String username){
        return userDao.exists(username);
    }

    public User get(String username){
        return userDao.get(username);
    }
}
