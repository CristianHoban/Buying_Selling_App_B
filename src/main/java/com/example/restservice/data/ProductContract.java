package com.example.restservice.data;

import com.example.restservice.model.Product;
import com.example.restservice.model.User;

import java.util.Optional;

public interface ProductContract {
    Optional<Product> findById(Long id);
    Product save(Product user);
    boolean existsById(Long id);
    void deleteById(Long id);
}
