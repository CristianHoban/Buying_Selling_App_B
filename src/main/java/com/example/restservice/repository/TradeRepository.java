package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.model.Review;
import com.example.restservice.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TradeRepository extends JpaRepository<Trade, Long> {
}