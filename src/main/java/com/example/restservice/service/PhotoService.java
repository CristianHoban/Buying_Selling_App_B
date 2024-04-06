package com.example.restservice.service;

import com.example.restservice.model.Photo;
import com.example.restservice.model.Product;
import com.example.restservice.repository.PhotoRepository;
import com.example.restservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public Optional<Photo> getPhotoById(Long id){
        return photoRepository.findById(id);
    }

    public Photo createPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public Photo updatePhoto(Long id, Photo newPhoto) {
        if (photoRepository.existsById(id)) {
            newPhoto.setId(id);
            return photoRepository.save(newPhoto);
        }
        return null;
    }

    @Transactional
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }

}
