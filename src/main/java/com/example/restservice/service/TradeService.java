package com.example.restservice.service;

import com.example.restservice.data.TradeContract;
import com.example.restservice.model.Trade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * se instantiaza un obiect de tipul userRepository, cu ajutorul caruia vom putea realiza operatii CRUD pe tabelul User
 * am realizat cate o functie care apeleaza fiecare din cele 4 operatii de baza
 */
@Service
public class TradeService {
    @Autowired
    private final TradeContract tradeContract;

    public TradeService(TradeContract tradeContract) {
        this.tradeContract = tradeContract;
    }

    public Optional<Trade> getTradeById(Long id) {
        return tradeContract.findById(id);
    }

    public Optional<List<Trade>> getTradesByEmail(String email){return tradeContract.findByEmail(email);}

    public Trade createTrade(Trade trade) {
        return tradeContract.save(trade);
    }

    public Trade updateTrade(Long id, Trade newTrade) {
        if (tradeContract.existsById(id)) {
            newTrade.setId(id);
            return tradeContract.save(newTrade);
        }
        return null;
    }



    @Transactional
    public void deleteTrade(Long id) {
        tradeContract.deleteById(id);
    }
}
