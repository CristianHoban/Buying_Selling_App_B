package com.example.restservice.service;

import com.example.restservice.data.ReviewContract;
import com.example.restservice.model.Review;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReviewService {
    @Autowired
    private final ReviewContract reviewContract;

    public ReviewService(ReviewContract reviewContract) {
        this.reviewContract = reviewContract;
    }

    public Optional<Review> getReviewById(Long id){
        return reviewContract.findById(id);
    }

    public Review createReview(Review review) {
        return reviewContract.save(review);
    }

    public Review updateReview(Long id, Review newReview) {
        if (reviewContract.existsById(id)) {
            newReview.setId(id);
            return reviewContract.save(newReview);
        }
        return null;
    }

    @Transactional
    public void deleteReview(Long id) {
        reviewContract.deleteById(id);
    }
}
