package com.example.restservice.service;

import com.example.restservice.data.TradeContract;
import com.example.restservice.model.Trade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TradeService {
    @Autowired
    private final TradeContract tradeContract;

    public TradeService(TradeContract tradeContract) {
        this.tradeContract = tradeContract;
    }

    /**
     * Retrieves a trade by ID.
     * @param id the ID of the trade to retrieve
     * @return an Optional containing the found trade, or empty if not found
     */
    public Optional<Trade> getTradeById(Long id) {
        return tradeContract.findById(id);
    }

    /**
     * Retrieves a list with trades in which a User with a specific email
     * is involved
     * @param email
     * @return a list of trades
     */
    public Optional<List<Trade>> getTradesByEmail(String email){return tradeContract.findByEmail(email);}

    /**
     * Creates a new trade.
     * @param trade the trade to create
     * @return the created trade
     */
    public Trade createTrade(Trade trade) {
        return tradeContract.save(trade);
    }

    /**
     * Updates an existing trade.
     * @param id the ID of the trade to update
     * @param newTrade the new trade data
     * @return the updated trade, or null if the trade does not exist
     */
    public Trade updateTrade(Long id, Trade newTrade) {
        if (tradeContract.existsById(id)) {
            newTrade.setId(id);
            return tradeContract.save(newTrade);
        }
        return null;
    }

    /**
     * Deletes a trade by ID.
     * @param id the ID of the trade to delete
     */

    @Transactional
    public void deleteTrade(Long id) {
        tradeContract.deleteById(id);
    }
}
