package com.shop.service;

import com.shop.dao.OrderDao;
import com.shop.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderService {
    private static final Logger logger = LogManager.getLogger(OrderService.class);
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orderDao.addOrder(order);
        logger.info("Order added: {}", order);
    }

    public Order getOrderById(int id) {
        Order order = orderDao.getOrderById(id);
        logger.info("Order retrieved: {}", order);
        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = orderDao.getAllOrders();
        logger.info("All orders retrieved: {}", orders);
        return orders;
    }

    public void updateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orderDao.updateOrder(order);
        logger.info("Order updated: {}", order);
    }

    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
        logger.info("Order deleted with id: {}", id);
    }
}