package com.example.restservice.data;

import com.example.restservice.model.Review;

import java.util.Optional;

public interface ReviewContract {
    Optional<Review> findById(Long id);
    Review save(Review review);
    boolean existsById(Long id);
    void deleteById(Long id);



}
