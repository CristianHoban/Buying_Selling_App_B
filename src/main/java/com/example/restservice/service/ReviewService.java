package com.example.restservice.service;

import com.example.restservice.model.Product;
import com.example.restservice.model.Review;
import com.example.restservice.repository.ProductRepository;
import com.example.restservice.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    public Optional<Review> getReviewById(Long id){
        return reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review newReview) {
        if (reviewRepository.existsById(id)) {
            newReview.setId(id);
            return reviewRepository.save(newReview);
        }
        return null;
    }

    @Transactional
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
