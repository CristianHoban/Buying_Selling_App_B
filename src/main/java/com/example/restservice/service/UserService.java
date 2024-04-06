package com.example.restservice.service;

import com.example.restservice.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import com.example.restservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * se instantiaza un obiect de tipul userRepository, cu ajutorul caruia vom putea realiza operatii CRUD pe tabelul User
 * am realizat cate o functie care apeleaza fiecare din cele 4 operatii de baza
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductService productService;

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

    @Transactional
    public void deleteUser(Long id) {
        productService.deleteAllProductsByUserId(id);
        userRepository.deleteById(id);
    }
}
