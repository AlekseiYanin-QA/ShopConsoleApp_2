package com.shop;

import com.shop.dao.UserDao;
import com.shop.dao.ProductDao;
import com.shop.dao.OrderDao;
import com.shop.dao.UserDaoImpl;
import com.shop.dao.ProductDaoImpl;
import com.shop.dao.OrderDaoImpl;
import com.shop.service.UserService;
import com.shop.service.ProductService;
import com.shop.service.OrderService;
import com.shop.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();

        UserService userService = AppConfig.getUserService(userDao);
        ProductService productService = AppConfig.getProductService(productDao);
        OrderService orderService = AppConfig.getOrderService(orderDao);

        ConsoleUI consoleUI = new ConsoleUI(userService, productService, orderService);
        consoleUI.start();
    }
}