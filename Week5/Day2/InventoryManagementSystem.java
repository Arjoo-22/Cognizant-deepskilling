/*
=====================================================
Exercise 2: Inventory Management System
=====================================================

Problem Statement:
Create:
1. Product Service
2. Inventory Service

Requirements:
• Manage products.
• Track stock levels.
• Simulate Eureka Service Discovery.
• Simulate Spring Cloud Config Server.

=====================================================
*/

import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Inventory {
    private Map<Integer, Integer> stock = new HashMap<>();

    public void addStock(int productId, int quantity) {
        stock.put(productId, quantity);
    }

    public void updateStock(int productId, int quantity) {
        stock.put(productId, quantity);
    }

    public void displayStock(int productId) {
        System.out.println("Product ID : " + productId);
        System.out.println("Available Stock : " + stock.get(productId));
    }
}

public class InventoryManagementSystem {

    public static void main(String[] args) {

        Product product = new Product(101, "Laptop", 65000);

        Inventory inventory = new Inventory();

        inventory.addStock(product.id, 50);

        System.out.println("Product Added Successfully");

        inventory.displayStock(product.id);

        inventory.updateStock(product.id, 35);

        System.out.println("\nAfter Stock Update");

        inventory.displayStock(product.id);

        System.out.println("\nEureka Server Connected");
        System.out.println("Configuration Loaded from Config Server");
    }
}