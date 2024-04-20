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
    private PhotoContract photoContract;

    public Optional<Photo> getPhotoById(Long id){
        return photoContract.findById(id);
    }

    public Photo createPhoto(Photo photo) {
        return photoContract.save(photo);
    }

    public Photo updatePhoto(Long id, Photo newPhoto) {
        if (photoContract.existsById(id)) {
            newPhoto.setId(id);
            return photoContract.save(newPhoto);
        }
        return null;
    }

    @Transactional
    public void deletePhoto(Long id) {
        photoContract.deleteById(id);
    }

}
