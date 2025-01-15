package com.shop.service;

import com.shop.dao.ProductDao;
import com.shop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1);
        product.setName("Laptop");
        product.setPrice(999.99);
    }

    @Test
    void testAddProduct() {
        productService.addProduct(product);
        verify(productDao, times(1)).addProduct(product);
    }

    @Test
    void testGetProductById() {
        when(productDao.getProductById(1)).thenReturn(product);

        Product result = productService.getProductById(1);
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        assertEquals(999.99, result.getPrice());

        verify(productDao, times(1)).getProductById(1);
    }

    @Test
    void testGetProductById_NotFound() {
        when(productDao.getProductById(1)).thenReturn(null);

        Product result = productService.getProductById(1);
        assertNull(result);

        verify(productDao, times(1)).getProductById(1);
    }

    @Test
    void testGetAllProducts() {
        when(productDao.getAllProducts()).thenReturn(Collections.singletonList(product));

        List<Product> result = productService.getAllProducts();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getName());

        verify(productDao, times(1)).getAllProducts();
    }

    @Test
    void testUpdateProduct() {
        productService.updateProduct(product);
        verify(productDao, times(1)).updateProduct(product);
    }

    @Test
    void testDeleteProduct() {
        productService.deleteProduct(1);
        verify(productDao, times(1)).deleteProduct(1);
    }

    @Test
    void testAddProduct_NullProduct() {
        // Проверяем, что при передаче null выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> productService.addProduct(null));
    }

    @Test
    void testUpdateProduct_NullProduct() {
        // Проверяем, что при передаче null выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> productService.updateProduct(null));
    }
}