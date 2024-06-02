package com.example.restservice.service;

import com.example.restservice.model.User;

import java.util.Optional;

/**
 * Interfata care are metodele care ne vor ajuta in modelarea bazei de date. Este realizata
 * pentru a facilita decuplarea.
 */
public interface UserService {
    public Optional<User> getUserById(Long id);
    public User createUser(User user);
    public User updateUser(Long id, User newUser);
    public void deleteUser(Long id);
    public void addBalanceToUsers(double amount);

    //public User registerNewUser(User user);

    public Optional<User> login(String email, String password);

    public Optional<User> findByEmail(String email);

    public User registerNewUser(User user);

    void updateBalance(Long userId, Double amount);


}
