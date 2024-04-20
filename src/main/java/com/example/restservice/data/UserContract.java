package com.example.restservice.data;

import com.example.restservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserContract {
    Optional<User> findById(Long id);
    User save(User user);
    boolean existsById(Long id);
    void deleteById(Long id);
    List<User> findAll();
    void addAmountToAllUsers(double amonunt);
}
