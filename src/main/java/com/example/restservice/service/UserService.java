package com.example.restservice.service;

import com.example.restservice.model.User;
import org.springframework.beans.factory.annotation.*;
import com.example.restservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User newUser) {
        if (userRepository.existsById(id)) {
            newUser.setId(id);
            return userRepository.save(newUser);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
