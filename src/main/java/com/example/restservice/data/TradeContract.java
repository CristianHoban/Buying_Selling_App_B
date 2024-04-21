package com.example.restservice.data;

import com.example.restservice.model.Trade;

import java.util.List;
import java.util.Optional;

/**
 * A contract that defines methods necessary for managing trade data
 */
public interface TradeContract {
    /**
     * A method that finds a trade by its ID
     * @param id
     * @return the trade with specific ID, if it is found
     */
    Optional<Trade> findById(Long id);
    /**
     * A method that saves a trade
     * It is used for creating method
     * @param trade
     * @return the saved trade
     */
    Trade save(Trade trade);

    /**
     * A method that finds all trades in which a user with a specific ID is involved
     * @param email
     * @return the list of trades, if at least one is found
     */
    Optional<List<Trade>> findByEmail(String email);

    /**
     * A method that checks if there is a trade with a specific ID
     * @param id
     * @return True - if there is a trade with the specific ID, False - otherwise
     */
    boolean existsById(Long id);
    /**
     * A method that trade a photo with a specific ID
     * @param id
     */
    void deleteById(Long id);

}
