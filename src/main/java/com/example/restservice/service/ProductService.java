package com.example.restservice.service;

import com.example.restservice.data.ProductContract;
import com.example.restservice.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductContract productContract;

    public ProductService(ProductContract productContract) {
        this.productContract = productContract;
    }


    /**
     * Retrieves a product by ID.
     * @param id the ID of the product to retrieve
     * @return an Optional containing the found product, or empty if not found
     */
    public Optional<Product> getProductById(Long id){
        return productContract.findById(id);
    }

    public Optional<List<Product>> getProductsByUserId(Long id){
        return productContract.findByUserId(id);
    }
    /**
     * Creates a new product.
     * @param product the product to create
     * @return the created product
     */
    public Product createProduct(Product product) {
        return productContract.save(product);
    }

    /**
     * Updates an existing product.
     * @param id the ID of the product to update
     * @param newProduct the new product data
     * @return the updated product, or null if the product does not exist
     */
    public Product updateProduct(Long id, Product newProduct) {
        if (productContract.existsById(id)) {
            newProduct.setId(id);
            return productContract.save(newProduct);
        }
        return null;
    }

    /**
     * Deletes a product by ID.
     * @param id the ID of the product to delete
     */
    @Transactional
    public void deleteProduct(Long id) {
        productContract.deleteById(id);
    }

    public Optional<List<Product>> getProductsByUserIdNotInTrade(Long userId) {
        return productContract.findAllByUserIdAndNotInTrade(userId);
    }
}
