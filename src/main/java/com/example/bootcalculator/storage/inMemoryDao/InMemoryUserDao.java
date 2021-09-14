package com.example.bootcalculator.storage.inMemoryDao;

import com.example.bootcalculator.entity.User;
import com.example.bootcalculator.storage.UserDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryUserDao implements UserDao {

    private static List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public boolean exists(String username) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public User get(String username) {
        List<User> userList = users.stream().filter(user1 -> user1.getUsername().equals(username)).collect(Collectors.toList());
        return userList.size()==1 ? userList.get(0) : null;
    }
}
