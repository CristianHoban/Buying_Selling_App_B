package com.example.restservice.data;

import com.example.restservice.model.Product;
import com.example.restservice.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ProductData implements ProductContract{

    private final ProductRepository productRepository;
    public ProductData(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public boolean existsById(Long id) {
        return this.productRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
