package com.shop;

import com.shop.dao.UserDao;
import com.shop.dao.ProductDao;
import com.shop.dao.OrderDao;
import com.shop.service.UserService;
import com.shop.service.ProductService;
import com.shop.service.OrderService;

public class AppConfig {
    public static UserService getUserService(UserDao userDao) {
        return new UserService(userDao);
    }

    public static ProductService getProductService(ProductDao productDao) {
        return new ProductService(productDao);
    }

    public static OrderService getOrderService(OrderDao orderDao) {
        return new OrderService(orderDao);
    }
}