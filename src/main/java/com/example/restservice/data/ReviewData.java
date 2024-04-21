package com.example.restservice.data;

import com.example.restservice.model.Review;
import com.example.restservice.repository.ReviewRepository;
import com.example.restservice.repository.TradeRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A class that is used for managing review data using JPA repository
 */
@Repository
public class ReviewData implements ReviewContract{

    private final ReviewRepository reviewRepository;

    public ReviewData(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    /**
     * A method that searches a review by a specific ID, by using findById() from JPA repository
     * @param id
     * @return the review found with the specific ID, if found
     */
    @Override
    public Optional<Review> findById(Long id) {
        return this.reviewRepository.findById(id);
    }

    /**
     * A method that saves a specific review, by using save() method from JPA repository
     * @param review
     * @return the saved review
     */
    @Override
    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }

    /**
     * A method that checks if there is a review with a specific ID, by using existsById() from JPA repository
     * @param id
     * @return True - if there is a review with the specific ID, False - otherwise
     */
    @Override
    public boolean existsById(Long id) {
        return this.reviewRepository.existsById(id);
    }

    /**
     * A method that deletes a review with a specific ID, by using deleteById() from JPA repository
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        this.reviewRepository.deleteById(id);
    }
}
