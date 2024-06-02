package com.example.restservice.data;

import com.example.restservice.model.Product;
import com.example.restservice.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * A class that is used for managing product data using JPA repository
 */
@Repository
public class ProductData implements ProductContract{

    private final ProductRepository productRepository;
    public ProductData(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    /**
     * A method that searches a product by a specific ID, by using findById() from JPA repository
     * @param id
     * @return the product found with the specific ID, if found
     */
    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    /**
     * A method that saves a specific product, by using save() method from JPA repository
     * @param product
     * @return the saved product
     */
    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }
    /**
     * A method that checks if there is a product with a specific ID, by using existsById() from JPA repository
     * @param id
     * @return True - if there is a product with the specific ID, False - otherwise
     */
    @Override
    public boolean existsById(Long id) {
        return this.productRepository.existsById(id);
    }

    /**
     * A method that deletes a product with a specific ID, by using deleteById() from JPA repository
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Optional<List<Product>> findByUserId(long id) {
        return this.productRepository.findByUserId(id);
    }

    @Override
    public Optional<List<Product>> findAllByUserIdAndNotInTrade(Long userId) {
        return this.productRepository.findAllByUserIdAndNotInTrade(userId);
    }

    @Override
    public Optional<List<Product>> findAvailableProductsByUserIdNot(Long userId) {
        return this.productRepository.findAvailableProductsByUserIdNot(userId);
    }
}
