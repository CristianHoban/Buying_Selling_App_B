package com.example.restservice.data;

import com.example.restservice.model.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeContract {
    Optional<Trade> findById(Long id);
    Trade save(Trade trade);
    Optional<List<Trade>> findByEmail(String email);
    boolean existsById(Long id);
    void deleteById(Long id);

}
