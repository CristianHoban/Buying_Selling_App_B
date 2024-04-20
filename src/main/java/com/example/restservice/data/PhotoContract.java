package com.example.restservice.data;

import com.example.restservice.model.Photo;
import com.example.restservice.model.User;

import java.util.Optional;

public interface PhotoContract {
    Optional<Photo> findById(Long id);
    Photo save(Photo photo);
    boolean existsById(Long id);
    void deleteById(Long id);
}
