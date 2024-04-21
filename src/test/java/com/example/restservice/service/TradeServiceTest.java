package com.example.restservice.service;

import com.example.restservice.data.TradeContract;
import com.example.restservice.model.Product;
import com.example.restservice.model.Trade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the TradeService class.
 */
public class TradeServiceTest {

    @Mock
    private TradeContract tradeContract;

    private TradeService tradeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        tradeService = new TradeService(tradeContract);
    }

    /**
     * Test for creating a trade.
     * Verifies that the trade is saved correctly.
     */
    @Test
    public void createTradeTest() {
        Trade trade = new Trade(1L, "example1@yahoo.com", "example2@yahoo.com", new Product());
        when(tradeContract.save(trade)).thenReturn(trade);

        Trade createdTrade = tradeService.createTrade(trade);
        verify(tradeContract).save(trade);
        assertEquals(trade, createdTrade);
    }

    /**
     * Test for retrieving a trade by its ID.
     * Verifies that the correct trade is returned when searching by ID.
     */
    @Test
    public void getTradeByIdTest() {
        Trade expectedTrade = new Trade(1L, "example1@yahoo.com", "example2@yahoo.com", new Product());
        Mockito.when(tradeContract.findById(1L)).thenReturn(Optional.of(expectedTrade));

        Optional<Trade> actualTrade = tradeService.getTradeById(1L);

        Mockito.verify(tradeContract).findById(1L);
        assertEquals(Optional.of(expectedTrade), actualTrade);
    }
    /**
     * Test for updating a trade.
     * Verifies that the trade is updated correctly when it exists.
     */
    @Test
    public void updateTradeTest1() {
        Trade newTrade = new Trade(1L, "example1@yahoo.com", "example2@yahoo.com", new Product());
        Mockito.when(tradeContract.existsById(1L)).thenReturn(true);
        Mockito.when(tradeContract.save(newTrade)).thenReturn(newTrade);

        Trade updatedTrade = tradeService.updateTrade(1L, newTrade);

        assertNotNull(updatedTrade);
        assertEquals(1L, updatedTrade.getId());
        Mockito.verify(tradeContract).existsById(1L);
        Mockito.verify(tradeContract).save(newTrade);

        assertEquals(newTrade, updatedTrade);
    }

    /**
     * Test for updating a trade that doesn't exist.
     * Verifies that the update operation fails and no changes are made.
     */
    @Test
    public void updateTradeTest2() {
        Long tradeId = 2L;
        Trade newTrade = new Trade(1L, "example1@yahoo.com", "example2@yahoo.com", new Product());
        Mockito.when(tradeContract.existsById(tradeId)).thenReturn(false);

        Trade updatedTrade = tradeService.updateTrade(tradeId, newTrade);

        assertNull(updatedTrade);
        Mockito.verify(tradeContract).existsById(tradeId);
        Mockito.verify(tradeContract, Mockito.never()).save(Mockito.any(Trade.class));
    }

    /**
     * Test for deleting a trade.
     * Verifies that the trade is deleted by its ID.
     */
    @Test
    public void deleteTradeTest() {
        tradeService.deleteTrade(1L);
        Mockito.verify(tradeContract, times(1)).deleteById(1L);
    }

    /**
     * Test for getting the trades where a user with a specific email is involved.
     */
    @Test
    public void getTradesByEmailTest() {
        Trade trade1 = new Trade(1L, "Ex1", "Ex3", new Product());
        Trade trade2 = new Trade(2L, "Ex2", "Ex1", new Product());
        List<Trade> expectedTrades = Arrays.asList(trade1, trade2);
        Mockito.when(tradeContract.findByEmail("Ex1")).thenReturn(Optional.of(expectedTrades));

        Optional<List<Trade>> actualTrades = tradeService.getTradesByEmail("Ex1");

        Mockito.verify(tradeContract).findByEmail("Ex1");
        assertEquals(Optional.of(expectedTrades), actualTrades);
    }
}
