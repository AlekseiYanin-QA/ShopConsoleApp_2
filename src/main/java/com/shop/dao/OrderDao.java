package com.shop.dao;

import com.shop.model.Order;
import java.util.List;

public interface OrderDao {
    void addOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void updateOrder(Order order);
    void deleteOrder(int id);
}