package com.example.restservice.data;

import com.example.restservice.model.Photo;
import com.example.restservice.repository.PhotoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A class that is used for managing photo data using JPA repository
 */
@Repository
public class PhotoData implements PhotoContract{
    private final PhotoRepository photoRepository;
    public PhotoData(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }

    /**
     * A method that searches a photo by a specific ID, by using findById() from JPA repository
     * @param id
     * @return the photo found with the specific ID, if found
     */
    @Override
    public Optional<Photo> findById(Long id) {
        return this.photoRepository.findById(id);
    }

    /**
     * A method that saves a specific photo, by using save() method from JPA repository
     * @param photo
     * @return the saved photo
     */
    @Override
    public Photo save(Photo photo) {
        return this.photoRepository.save(photo);
    }

    /**
     * A method that checks if there is a photo with a specific ID, by using existsById() from JPA repository
     * @param id
     * @return True - if there is a photo with the specific ID, False - otherwise
     */
    @Override
    public boolean existsById(Long id) {
        return this.photoRepository.existsById(id);
    }

    /**
     * A method that deletes a photo with a specific ID, by using deleteById() from JPA repository
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        this.photoRepository.deleteById(id);
    }
}
