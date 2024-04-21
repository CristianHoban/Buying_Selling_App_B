package com.example.restservice.service;

import com.example.restservice.data.ProductContract;
import com.example.restservice.model.Product;
import com.example.restservice.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the ProductService class.
 */
public class ProductServiceTest {

    @Mock
    private ProductContract productContract;

    private ProductService productService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(productContract);
    }

    /**
     * Test for creating a product.
     * Verifies that the product is saved correctly.
     */
    @Test
    public void createProductTest() {
        Product product = new Product(1L,new User(),  "Example", "Example", 1, 200, "Example");

        when(productContract.save(product)).thenReturn(product);

        Product createdProduct = productService.createProduct(product);
        verify(productContract).save(product);
        assertEquals(product, createdProduct);
    }

    /**
     * Test for retrieving a product by its ID.
     * Verifies that the correct product is returned when searching by ID.
     */
    @Test
    public void getProductByIdTest() {

        Product expectedProduct = new Product(1L,new User(),  "Example", "Example", 1, 200, "Example");

        Mockito.when(productContract.findById(1L)).thenReturn(Optional.of(expectedProduct));

        Optional<Product> actualProduct = productService.getProductById(1L);

        Mockito.verify(productContract).findById(1L);

        assertEquals(Optional.of(expectedProduct), actualProduct);
    }

    /**
     * Test for updating a product.
     * Verifies that the product is updated correctly when it exists.
     */
    @Test
    public void updateProductTest1() {
        Product newProduct = new Product(1L,new User(),  "Example", "Example", 1, 200, "Example");
        Mockito.when(productContract.existsById(1L)).thenReturn(true);
        Mockito.when(productContract.save(newProduct)).thenReturn(newProduct);

        Product updatedProduct = productService.updateProduct(1L, newProduct);

        assertNotNull(updatedProduct);
        assertEquals(1L, updatedProduct.getId());
        Mockito.verify(productContract).existsById(1L);
        Mockito.verify(productContract).save(newProduct);

        assertEquals(newProduct, updatedProduct);
    }

    /**
     * Test for updating a product that doesn't exist.
     * Verifies that the update operation fails and no changes are made.
     */
    @Test
    public void updateProductTest2() {
        Long productId = 2L;
        Product newProduct = new Product(1L,new User(),  "Example", "Example", 1, 200, "Example");
        Mockito.when(productContract.existsById(productId)).thenReturn(false);

        Product updatedProduct = productService.updateProduct(productId, newProduct);

        assertNull(updatedProduct);
        Mockito.verify(productContract).existsById(productId);
        Mockito.verify(productContract, Mockito.never()).save(Mockito.any(Product.class));
    }

    /**
     * Test for deleting a product.
     * Verifies that the product is deleted by its ID.
     */
    @Test
    public void deleteProductTest() {
        productService.deleteProduct(1L);
        Mockito.verify(productContract, times(1)).deleteById(1L);
    }

}
