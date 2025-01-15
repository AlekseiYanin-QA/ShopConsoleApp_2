package com.shop.ui;

import com.shop.service.UserService;
import com.shop.service.ProductService;
import com.shop.service.OrderService;
import com.shop.model.User;
import com.shop.model.Product;
import com.shop.model.Order;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public ConsoleUI(UserService userService, ProductService productService, OrderService orderService) {
        this.scanner = new Scanner(System.in);
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    public void start() {
        while (true) {
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Добавить товар");
            System.out.println("3. Добавить заказ");
            System.out.println("4. Выйти");

            int choice = 0;
            boolean validInput = false;

            // Проверка ввода для выбора действия
            while (!validInput) {
                try {
                    System.out.print("Введите ваш выбор: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                    scanner.nextLine(); // очистка некорректного ввода
                }
            }

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    addOrder();
                    break;
                case 4:
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void addUser() {
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();

        String email;
        while (true) {
            System.out.println("Введите email пользователя:");
            email = scanner.nextLine();

            // Проверка валидности email
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Некорректный email. Пожалуйста, введите email в формате example@example.com.");
            }
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.addUser(user);
    }

    // Метод для проверки валидности email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    private void addProduct() {
        System.out.println("Введите название товара:");
        String productName = scanner.nextLine();

        double price = 0;
        boolean validPrice = false;

        // Проверка ввода для цены товара
        while (!validPrice) {
            try {
                System.out.println("Введите цену товара:");
                price = scanner.nextDouble();
                scanner.nextLine(); // очистка буфера
                validPrice = true;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите корректное число для цены.");
                scanner.nextLine(); // очистка некорректного ввода
            }
        }

        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);
        productService.addProduct(product);
    }

    private void addOrder() {
        int userId = 0;
        int productId = 0;
        int quantity = 0;

        // Проверка ввода для ID пользователя
        while (true) {
            try {
                System.out.println("Введите ID пользователя:");
                userId = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите корректное число для ID пользователя.");
                scanner.nextLine(); // очистка некорректного ввода
            }
        }

        // Проверка ввода для ID товара
        while (true) {
            try {
                System.out.println("Введите ID товара:");
                productId = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите корректное число для ID товара.");
                scanner.nextLine(); // очистка некорректного ввода
            }
        }

        // Проверка ввода для количества
        while (true) {
            try {
                System.out.println("Введите количество:");
                quantity = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите корректное число для количества.");
                scanner.nextLine(); // очистка некорректного ввода
            }
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(quantity);
        orderService.addOrder(order);
    }
}