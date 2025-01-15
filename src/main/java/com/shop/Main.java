package com.shop;

import com.shop.dao.UserDao;
import com.shop.dao.ProductDao;
import com.shop.dao.OrderDao;
import com.shop.service.UserService;
import com.shop.service.ProductService;
import com.shop.service.OrderService;
import com.shop.model.User;
import com.shop.model.Product;
import com.shop.model.Order;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();

        UserService userService = AppConfig.getUserService(userDao);
        ProductService productService = AppConfig.getProductService(productDao);
        OrderService orderService = AppConfig.getOrderService(orderDao);

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Add Product");
            System.out.println("3. Add Order");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter user name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter user email:");
                    String email = scanner.nextLine();
                    User user = new User();
                    user.setName(name);
                    user.setEmail(email);
                    userService.addUser(user);
                    break;
                case 2:
                    System.out.println("Enter product name:");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    Product product = new Product();
                    product.setName(productName);
                    product.setPrice(price);
                    productService.addProduct(product);
                    break;
                case 3:
                    System.out.println("Enter user id:");
                    int userId = scanner.nextInt();
                    System.out.println("Enter product id:");
                    int productId = scanner.nextInt();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Order order = new Order();
                    order.setUserId(userId);
                    order.setProductId(productId);
                    order.setQuantity(quantity);
                    orderService.addOrder(order);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}