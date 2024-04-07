package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import com.example.restservice.model.Review;
import com.example.restservice.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TradeRepository extends JpaRepository<Trade, Long> {
    @Query("SELECT t FROM Trade t WHERE t.email_s = :email OR t.email_b = :email")
    Optional<List<Trade>> findByEmail(@Param("email") String email);
}