package com.example.restservice.data;

import com.example.restservice.model.Product;
import com.example.restservice.model.User;

import java.util.List;
import java.util.Optional;

/**
 * A contract that defines methods necessary for managing product data
 */
public interface ProductContract {
    /**
     * A method that finds a product by its ID
     * @param id
     * @return the product with specific ID, if it is found
     */
    Optional<Product> findById(Long id);
    /**
     * A method that saves a product
     * It is used for creating method
     * @param product
     * @return the saved product
     */
    Product save(Product product);
    /**
     * A method that checks if there is a product with a specific ID
     * @param id
     * @return True - if there is a product with the specific ID, False - otherwise
     */
    boolean existsById(Long id);
    /**
     * A method that deletes a product with a specific ID
     * @param id
     */
    void deleteById(Long id);

    Optional<List<Product>> findByUserId(long id);

    Optional<List<Product>> findAllByUserIdAndNotInTrade(Long userId);
}
