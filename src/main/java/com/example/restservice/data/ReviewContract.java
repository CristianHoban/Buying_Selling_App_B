package com.example.restservice.data;

import com.example.restservice.model.Review;

import java.util.Optional;

/**
 * A contract that defines methods necessary for managing review data
 */
public interface ReviewContract {
    /**
     * A method that finds a review by its ID
     * @param id
     * @return the review with specific ID, if it is found
     */
    Optional<Review> findById(Long id);
    /**
     * A method that saves a review
     * It is used for creating method
     * @param review
     * @return the saved review
     */
    Review save(Review review);
    /**
     * A method that checks if there is a review with a specific ID
     * @param id
     * @return True - if there is a review with the specific ID, False - otherwise
     */
    boolean existsById(Long id);
    /**
     * A method that deletes a review with a specific ID
     * @param id
     */
    void deleteById(Long id);



}
