package com.shop.service;

import com.shop.dao.ProductDao;
import com.shop.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductService {
    private static final Logger logger = LogManager.getLogger(ProductService.class);
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        productDao.addProduct(product);
        logger.info("Product added: {}", product);
    }

    public Product getProductById(int id) {
        Product product = productDao.getProductById(id);
        logger.info("Product retrieved: {}", product);
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productDao.getAllProducts();
        logger.info("All products retrieved: {}", products);
        return products;
    }

    public void updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        productDao.updateProduct(product);
        logger.info("Product updated: {}", product);
    }

    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
        logger.info("Product deleted with id: {}", id);
    }
}