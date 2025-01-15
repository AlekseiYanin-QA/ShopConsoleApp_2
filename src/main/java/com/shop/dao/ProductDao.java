package com.shop.dao;

import com.shop.model.Product;
import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(int id);
}