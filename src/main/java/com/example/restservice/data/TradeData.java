package com.example.restservice.data;

import com.example.restservice.model.Trade;
import com.example.restservice.repository.TradeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class TradeData implements TradeContract {

    private final TradeRepository tradeRepository;

    public TradeData(TradeRepository tradeRepository){
        this.tradeRepository = tradeRepository;
    }

    @Override
    public Optional<Trade> findById(Long id) {
        return this.tradeRepository.findById(id);
    }

    @Override
    public Trade save(Trade trade) {
        return this.tradeRepository.save(trade);
    }

    @Override
    public Optional<List<Trade>> findByEmail(String email) {
        return tradeRepository.findByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return this.tradeRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.tradeRepository.deleteById(id);
    }
}
