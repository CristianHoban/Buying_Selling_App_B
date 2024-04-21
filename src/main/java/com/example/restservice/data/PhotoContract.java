package com.example.restservice.data;

import com.example.restservice.model.Photo;
import com.example.restservice.model.User;

import java.util.Optional;

/**
 * A contract that defines methods necessary for managing photo data
 */
public interface PhotoContract {

    /**
     * A method that finds a photo by its ID
     * @param id
     * @return the photo with specific ID, if it is found
     */
    Optional<Photo> findById(Long id);

    /**
     * A method that saves a photo
     * It is used for creating method
     * @param photo
     * @return the saved photo
     */
    Photo save(Photo photo);

    /**
     * A method that checks if there is a photo with a specific ID
     * @param id
     * @return True - if there is a photo with the specific ID, False - otherwise
     */
    boolean existsById(Long id);

    /**
     * A method that deletes a photo with a specific ID
     * @param id
     */
    void deleteById(Long id);
}
