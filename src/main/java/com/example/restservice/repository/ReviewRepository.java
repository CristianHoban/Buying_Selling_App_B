package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    void deleteByUserId(Long userId);
}