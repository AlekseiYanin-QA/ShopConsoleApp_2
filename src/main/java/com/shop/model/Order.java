package com.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private int id;
    private int userId;
    private int productId;
    private int quantity;
}