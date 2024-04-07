package com.example.restservice.service;

import com.example.restservice.model.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> getUserById(Long id);
    public User createUser(User user);
    public User updateUser(Long id, User newUser);
    public void deleteUser(Long id);
    public void addBalanceToUsers(double amount);

}
