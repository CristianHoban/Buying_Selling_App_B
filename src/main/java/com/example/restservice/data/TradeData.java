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

/**
 * A class that is used for managing trade data using JPA repository
 */
@Repository
public class TradeData implements TradeContract {


    private final TradeRepository tradeRepository;

    public TradeData(TradeRepository tradeRepository){
        this.tradeRepository = tradeRepository;
    }

    /**
     * A method that searches a trade by a specific ID, by using findById() from JPA repository
     * @param id
     * @return the trade found with the specific ID, if found
     */
    @Override
    public Optional<Trade> findById(Long id) {
        return this.tradeRepository.findById(id);
    }

    /**
     * A method that saves a specific trade, by using save() method from JPA repository
     * @param trade
     * @return the saved trade
     */
    @Override
    public Trade save(Trade trade) {
        return this.tradeRepository.save(trade);
    }

    /**
     * A method that finds all trades in which a user with a specific ID is involved, using a query
     * implemented in tradeRepository that extends JPA repository
     * @param email
     * @return the list of trades, if at least one is found
     */
    @Override
    public Optional<List<Trade>> findByEmail(String email) {
        return tradeRepository.findByEmail(email);
    }

    /**
     * A method that checks if there is a trade with a specific ID, by using existsById() from JPA repository
     * @param id
     * @return True - if there is a trade with the specific ID, False - otherwise
     */
    @Override
    public boolean existsById(Long id) {
        return this.tradeRepository.existsById(id);
    }

    /**
     * A method that deletes a trade with a specific ID, by using deleteById() from JPA repository
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        this.tradeRepository.deleteById(id);
    }
}
