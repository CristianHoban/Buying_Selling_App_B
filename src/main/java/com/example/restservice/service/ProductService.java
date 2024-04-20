package com.example.restservice.service;

import com.example.restservice.data.ProductContract;
import com.example.restservice.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductContract productContract;

    public Optional<Product> getProductById(Long id){
        return productContract.findById(id);
    }

    public Product createProduct(Product product) {
        return productContract.save(product);
    }

    public Product updateProduct(Long id, Product newProduct) {
        if (productContract.existsById(id)) {
            newProduct.setId(id);
            return productContract.save(newProduct);
        }
        return null;
    }

    @Transactional
    public void deleteProduct(Long id) {
        productContract.deleteById(id);
    }
}
