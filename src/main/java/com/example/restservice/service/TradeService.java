package com.example.restservice.service;

import com.example.restservice.model.Trade;
import com.example.restservice.model.User;
import com.example.restservice.repository.TradeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import com.example.restservice.repository.UserRepository;
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
    private TradeRepository tradeRepository;


    public Optional<Trade> getTradeById(Long id) {
        return tradeRepository.findById(id);
    }

    public Optional<List<Trade>> getTradesByEmail(String email){return tradeRepository.findByEmail(email);}

    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Trade updateTrade(Long id, Trade newTrade) {
        if (tradeRepository.existsById(id)) {
            newTrade.setId(id);
            return tradeRepository.save(newTrade);
        }
        return null;
    }



    @Transactional
    public void deleteTrade(Long id) {
        tradeRepository.deleteById(id);
    }
}
