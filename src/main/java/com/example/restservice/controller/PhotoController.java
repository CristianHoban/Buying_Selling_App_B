package com.example.restservice.controller;

import com.example.restservice.model.Photo;
import com.example.restservice.model.Product;
import com.example.restservice.model.User;
import com.example.restservice.service.PhotoService;
import com.example.restservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;


    @GetMapping("/get/{id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable Long id) {
        Optional<Photo> photo = photoService.getPhotoById(id);
        return photo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/add")
    public ResponseEntity<Photo> createPhoto(@RequestBody  Photo photo) {
        Photo createdPhoto = photoService.createPhoto(photo);
        return new ResponseEntity<>(createdPhoto, HttpStatus.CREATED);
    }


    @PutMapping("/put/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Long id, @RequestBody Photo photo) {
        Photo updatedPhoto = photoService.updatePhoto(id, photo);
        if (updatedPhoto != null) {
            return new ResponseEntity<>(updatedPhoto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        photoService.deletePhoto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
