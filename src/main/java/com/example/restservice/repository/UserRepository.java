package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}