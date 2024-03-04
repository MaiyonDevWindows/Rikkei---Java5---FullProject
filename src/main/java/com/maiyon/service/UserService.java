package com.maiyon.service;

import com.maiyon.model.entity.User;

import java.util.List;

public interface UserService {
    User findByUserId(Long userId);
    User findByUsername(String username);
    List<User> findAllUser();
    void changeUserStatus(Long userId);
    void updateUser(User user);
    void register(User user);
}
