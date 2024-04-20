package com.example.restservice.data;

import com.example.restservice.model.Photo;
import com.example.restservice.repository.PhotoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class PhotoData implements PhotoContract{
    private final PhotoRepository photoRepository;
    public PhotoData(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }

    @Override
    public Optional<Photo> findById(Long id) {
        return this.photoRepository.findById(id);
    }

    @Override
    public Photo save(Photo photo) {
        return this.photoRepository.save(photo);
    }

    @Override
    public boolean existsById(Long id) {
        return this.photoRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.photoRepository.deleteById(id);
    }
}
