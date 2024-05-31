package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import com.example.restservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteByUserId(Long userId);
    Optional<List<Product>> findByUserId(long id);

    @Query("SELECT p FROM Product p WHERE p.user.id = :userId AND p.id NOT IN (SELECT t.product.id FROM Trade t WHERE t.product IS NOT NULL)")
    Optional<List<Product>> findAllByUserIdAndNotInTrade(Long userId);
}