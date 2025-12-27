package com.examly.springapp.service;

import com.examly.springapp.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> store = new HashMap<>();
    private long idCounter = 1;

    @Override
    public User addUser(User user) {
        user.setUserId(idCounter++);
        store.put(user.getUserId(), user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(store.values());
    }

    @Override
    public User getUserById(Long id) {
        return store.get(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        user.setUserId(id);
        store.put(id, user);
        return user;
    }
}
