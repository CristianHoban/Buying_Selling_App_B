package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interfata este realizata pentru a accesa elementele de tip User tin baza de date
 * extince JpaRepository pentru a mosteni operatiile basic CRUD(Create, Read, Delete, Update)
 */
public interface UserRepository extends JpaRepository<User, Long> {
}