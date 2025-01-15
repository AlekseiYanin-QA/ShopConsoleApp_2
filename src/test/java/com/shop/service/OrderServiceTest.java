package com.shop.service;

import com.shop.dao.OrderDao;
import com.shop.model.Order;
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
public class OrderServiceTest {

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderService orderService;

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.setId(1);
        order.setUserId(1);
        order.setProductId(1);
        order.setQuantity(2);
    }

    @Test
    void testAddOrder() {
        orderService.addOrder(order);
        verify(orderDao, times(1)).addOrder(order);
    }

    @Test
    void testGetOrderById() {
        when(orderDao.getOrderById(1)).thenReturn(order);

        Order result = orderService.getOrderById(1);
        assertNotNull(result);
        assertEquals(1, result.getUserId());
        assertEquals(1, result.getProductId());
        assertEquals(2, result.getQuantity());

        verify(orderDao, times(1)).getOrderById(1);
    }

    @Test
    void testGetOrderById_NotFound() {
        when(orderDao.getOrderById(1)).thenReturn(null);

        Order result = orderService.getOrderById(1);
        assertNull(result);

        verify(orderDao, times(1)).getOrderById(1);
    }

    @Test
    void testGetAllOrders() {
        when(orderDao.getAllOrders()).thenReturn(Collections.singletonList(order));

        List<Order> result = orderService.getAllOrders();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getUserId());

        verify(orderDao, times(1)).getAllOrders();
    }

    @Test
    void testUpdateOrder() {
        orderService.updateOrder(order);
        verify(orderDao, times(1)).updateOrder(order);
    }

    @Test
    void testDeleteOrder() {
        orderService.deleteOrder(1);
        verify(orderDao, times(1)).deleteOrder(1);
    }

    @Test
    void testAddOrder_NullOrder() {
        // Проверяем, что при передаче null выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(null));
    }

    @Test
    void testUpdateOrder_NullOrder() {
        // Проверяем, что при передаче null выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> orderService.updateOrder(null));
    }
}