package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.model.Photo;
import com.example.restservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhotoRepository extends JpaRepository<Photo, Long> {
}