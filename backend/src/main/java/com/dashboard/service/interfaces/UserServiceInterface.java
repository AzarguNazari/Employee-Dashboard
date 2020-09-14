package com.dashboard.service.interfaces;

import com.dashboard.model.User;

import java.util.List;

public interface UserServiceInterface {
    void save(User user);
    void delete(Integer userId);
    void update(Integer userId, User user);
    List<User> getAllUsers();
    User getUserById(Integer userId);
}
