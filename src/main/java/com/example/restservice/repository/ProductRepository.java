package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteByUserId(Long userId);
}