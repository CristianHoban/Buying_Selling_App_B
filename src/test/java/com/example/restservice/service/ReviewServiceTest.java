package com.example.restservice.service;

import com.example.restservice.data.ReviewContract;
import com.example.restservice.model.Review;
import com.example.restservice.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the ReviewService class.
 */
public class ReviewServiceTest {

    @Mock
    private ReviewContract reviewContract;

    private ReviewService reviewService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewService(reviewContract);
    }
    /**
     * Test for creating a review.
     * Verifies that the review is saved correctly.
     */
    @Test
    public void createReviewTest() {
        Review review = new Review(1L,new User(), 5, "Example");
        when(reviewContract.save(review)).thenReturn(review);

        Review createdReview = reviewService.createReview(review);
        verify(reviewContract).save(review);
        assertEquals(review, createdReview);
    }

    /**
     * Test for retrieving a review by its ID.
     * Verifies that the correct review is returned when searching by ID.
     */
    @Test
    public void getReviewByIdTest() {
        Review expectedReview = new Review(1L,new User(), 5, "Example");
        Mockito.when(reviewContract.findById(1L)).thenReturn(Optional.of(expectedReview));

        Optional<Review> actualReview = reviewService.getReviewById(1L);

        Mockito.verify(reviewContract).findById(1L);
        assertEquals(Optional.of(expectedReview), actualReview);
    }

    /**
     * Test for updating a review.
     * Verifies that the review is updated correctly when it exists.
     */
    @Test
    public void updateReviewTest1() {
        Review newReview = new Review(1L,new User(), 5, "Example");
        Mockito.when(reviewContract.existsById(1L)).thenReturn(true);
        Mockito.when(reviewContract.save(newReview)).thenReturn(newReview);

        Review updatedReview = reviewService.updateReview(1L, newReview);

        assertNotNull(updatedReview);
        assertEquals(1L, updatedReview.getId());
        Mockito.verify(reviewContract).existsById(1L);
        Mockito.verify(reviewContract).save(newReview);

        assertEquals(newReview, updatedReview);
    }

    /**
     * Test for updating a review that doesn't exist.
     * Verifies that the update operation fails and no changes are made.
     */
    @Test
    public void updateReviewTest2() {
        Long reviewId = 2L;
        Review newReview = new Review(1L,new User(), 5, "Example");
        Mockito.when(reviewContract.existsById(reviewId)).thenReturn(false);

        Review updatedReview = reviewService.updateReview(reviewId, newReview);

        assertNull(updatedReview);
        Mockito.verify(reviewContract).existsById(reviewId);
        Mockito.verify(reviewContract, Mockito.never()).save(Mockito.any(Review.class));
    }
    /**
     * Test for deleting a photo.
     * Verifies that the photo is deleted by its ID.
     */
    @Test
    public void deleteReviewTest() {
        reviewService.deleteReview(1L);
        Mockito.verify(reviewContract, times(1)).deleteById(1L);
    }
}
