package com.example.restservice.service;

import com.example.restservice.data.ReviewContract;
import com.example.restservice.model.Review;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewService {
    @Autowired
    private final ReviewContract reviewContract;

    public ReviewService(ReviewContract reviewContract) {
        this.reviewContract = reviewContract;
    }

    /**
     * Retrieves a review by ID.
     * @param id the ID of the review to retrieve
     * @return an Optional containing the found review, or empty if not found
     */
    public Optional<Review> getReviewById(Long id){
        return reviewContract.findById(id);
    }

    /**
     * Creates a new review.
     * @param review the review to create
     * @return the created review
     */
    public Review createReview(Review review) {
        return reviewContract.save(review);
    }

    /**
     * Updates an existing review.
     * @param id the ID of the review to update
     * @param newReview the new review data
     * @return the updated review, or null if the review does not exist
     */
    public Review updateReview(Long id, Review newReview) {
        if (reviewContract.existsById(id)) {
            newReview.setId(id);
            return reviewContract.save(newReview);
        }
        return null;
    }

    /**
     * Deletes a review by ID.
     * @param id the ID of the review to delete
     */
    @Transactional
    public void deleteReview(Long id) {
        reviewContract.deleteById(id);
    }

    public Optional<List<Review>> findByUserId(Long id){
        return reviewContract.findByUserId(id);
    }
}
