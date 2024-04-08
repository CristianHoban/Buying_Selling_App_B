package com.example.restservice.controller;

import com.example.restservice.model.Photo;
import com.example.restservice.model.Product;
import com.example.restservice.model.Trade;
import com.example.restservice.model.User;
import com.example.restservice.service.PhotoService;
import com.example.restservice.service.ProductService;
import com.example.restservice.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trades")
public class TradeController {
    @Autowired
    private TradeService tradeService;


    @GetMapping("/get/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable Long id) {
        Optional<Trade> trade = tradeService.getTradeById(id);
        return trade.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/add")
    public ResponseEntity<Trade> createTrade(@RequestBody  Trade trade) {
        Trade createdTrade = tradeService.createTrade(trade);
        return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
    }


    @PutMapping("/put/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Long id, @RequestBody Trade trade) {
        Trade updatedTrade = tradeService.updateTrade(id, trade);
        if (updatedTrade != null) {
            return new ResponseEntity<>(updatedTrade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable Long id) {
        tradeService.deleteTrade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Endpoint care returneaza tranzactiile facute de un anumit User pe baza adresei de email, cele de cumparare,
     * cat si cele de vanzare
     * @param email
     * @return lista cu trade-urile care au email-ul de la parametru la vanzator sau la cumparator
     */
    @GetMapping("/getTradesByEmail/{email}")
    public ResponseEntity<List<Trade>> getTradesByEmail(@PathVariable String email) {
        Optional<List<Trade>> trades = tradeService.getTradesByEmail(email);
        return trades.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
