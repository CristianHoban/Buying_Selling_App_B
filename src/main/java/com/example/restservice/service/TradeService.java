package com.example.restservice.service;

import com.example.restservice.data.ProductContract;
import com.example.restservice.data.TradeContract;
import com.example.restservice.data.UserContract;
import com.example.restservice.model.Product;
import com.example.restservice.model.Trade;
import com.example.restservice.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TradeService {
    @Autowired
    private final TradeContract tradeContract;
    @Autowired
    private final UserServiceImpl userService;



    public TradeService(TradeContract tradeContract, UserServiceImpl userService) {
        this.tradeContract = tradeContract;
        this.userService = userService;
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

    public void executeTransaction(Long buyerId, Long sellerId, Product product) {
        // Fetch the product price
        Double amount = product.getPrice();

        // Update balances
        userService.updateBalance(buyerId, -amount);  // Subtract from buyer
        userService.updateBalance(sellerId, amount);  // Add to seller

        // Fetch user details safely using Optional
        Optional<User> optionalBuyer = userService.getUserById(buyerId);
        Optional<User> optionalSeller = userService.getUserById(sellerId);

        // Record the transaction in the database only if both users are found
        if (optionalBuyer.isPresent() && optionalSeller.isPresent()) {
            User userB = optionalBuyer.get();
            User userS = optionalSeller.get();

            Trade trade = new Trade();
            trade.setEmail_b(userB.getEmail());  // Set buyer's email
            trade.setEmail_s(userS.getEmail());  // Set seller's email
            trade.setProduct(product);  // Assuming there's a method to set product directly
            tradeContract.save(trade);  // Assuming this should be tradeRepository instead of tradeContract
        } else {
            throw new RuntimeException("Buyer or seller not found");  // or handle this scenario as per your business logic
        }
    }

}
