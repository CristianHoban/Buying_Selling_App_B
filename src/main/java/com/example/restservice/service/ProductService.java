package com.example.restservice.service;

import com.example.restservice.model.Product;
import com.example.restservice.model.User;
import com.example.restservice.repository.PhotoRepository;
import com.example.restservice.repository.ProductRepository;
import com.example.restservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PhotoService photoService;

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product newProduct) {
        if (productRepository.existsById(id)) {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        }
        return null;
    }

    @Transactional
    public void deleteProduct(Long id) {
        photoService.deleteAllPhotosByProductId(id);
        productRepository.deleteById(id);
    }
    @Transactional
    public void deleteAllProductsByUserId(Long userId){
        productRepository.deleteByUserId(userId);
    }
}
