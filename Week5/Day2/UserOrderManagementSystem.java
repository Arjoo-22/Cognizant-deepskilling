/*
==========================================================
Exercise 1: User and Order Management System
==========================================================

Problem Statement:
Create two microservices:

1. User Service
   - Add User
   - View User

2. Order Service
   - Add Order
   - View Order

Requirements:
• Use REST APIs.
• Services communicate using OpenFeign/WebClient.
• Store data in MySQL/PostgreSQL.

Note:
This single Java file is a simplified demonstration of the logic.
In a real Spring Boot project, these classes should be placed in
separate files.
==========================================================
*/

import java.util.*;

//---------------- User Entity ----------------
class User {

    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

//---------------- Order Entity ----------------
class Order {

    private int orderId;
    private int userId;
    private String product;
    private int quantity;

    public Order(int orderId, int userId, String product, int quantity) {
        this.orderId = orderId;
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("Order ID : " + orderId);
        System.out.println("User ID  : " + userId);
        System.out.println("Product  : " + product);
        System.out.println("Quantity : " + quantity);
    }
}

//---------------- User Service ----------------
class UserService {

    private Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(int id) {
        return users.get(id);
    }
}

//---------------- Order Service ----------------
class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        for (Order order : orders) {
            order.display();
            System.out.println("-----------------------");
        }
    }
}

//---------------- Main Class ----------------
public class UserOrderManagementSystem {

    public static void main(String[] args) {

        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        // Add User
        User user = new User(1, "Rahul", "rahul@gmail.com");
        userService.addUser(user);

        // Fetch User (simulating OpenFeign/WebClient call)
        User fetchedUser = userService.getUser(1);

        if (fetchedUser != null) {

            System.out.println("User Found");
            System.out.println("Name : " + fetchedUser.getName());

            // Place Order
            Order order = new Order(101, fetchedUser.getId(),
                    "Laptop", 2);

            orderService.placeOrder(order);
        }

        System.out.println("\nOrders\n");

        orderService.displayOrders();
    }
}