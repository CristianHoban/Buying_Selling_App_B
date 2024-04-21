package com.example.restservice.service;

import com.example.restservice.data.PhotoContract;
import com.example.restservice.model.Photo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PhotoService {
    @Autowired
    private final PhotoContract photoContract;

    public PhotoService(PhotoContract photoContract) {
        this.photoContract = photoContract;
    }


    /**
     * Retrieves a photo by ID.
     * @param id the ID of the photo to retrieve
     * @return an Optional containing the found photo, or empty if not found
     */
    public Optional<Photo> getPhotoById(Long id){
        return photoContract.findById(id);
    }

    /**
     * Creates a new photo.
     * @param photo the photo to create
     * @return the created photo
     */
    public Photo createPhoto(Photo photo) {
        return photoContract.save(photo);
    }

    /**
     * Updates an existing photo.
     * @param id the ID of the photo to update
     * @param newPhoto the new photo data
     * @return the updated photo, or null if the photo does not exist
     */
    public Photo updatePhoto(Long id, Photo newPhoto) {
        if (photoContract.existsById(id)) {
            newPhoto.setId(id);
            return photoContract.save(newPhoto);
        }
        return null;
    }

    /**
     * Deletes a photo by ID.
     * @param id the ID of the photo to delete
     */
    @Transactional
    public void deletePhoto(Long id) {
        photoContract.deleteById(id);
    }

}
