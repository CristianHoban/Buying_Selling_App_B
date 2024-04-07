package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

/**
 * interfata este realizata pentru a accesa elementele de tip User tin baza de date
 * extince JpaRepository pentru a mosteni operatiile basic CRUD(Create, Read, Delete, Update)
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.balance = u.balance + :amount")
    void addAmountToAllUsers(@Param("amount") double amount);
}