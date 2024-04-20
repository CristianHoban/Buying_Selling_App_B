package com.example.restservice.data;

import com.example.restservice.model.Review;
import com.example.restservice.repository.ReviewRepository;
import com.example.restservice.repository.TradeRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ReviewData implements ReviewContract{

    private final ReviewRepository reviewRepository;

    public ReviewData(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    @Override
    public Optional<Review> findById(Long id) {
        return this.reviewRepository.findById(id);
    }

    @Override
    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }

    @Override
    public boolean existsById(Long id) {
        return this.reviewRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.reviewRepository.deleteById(id);
    }
}
