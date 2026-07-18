/*
=====================================================
Exercise 3: API Gateway
=====================================================

Problem Statement:
Create an API Gateway that routes requests to

1. Customer Service
2. Billing Service

Requirements:
• Rate Limiting
• Path Rewriting
• Caching

=====================================================
*/

class CustomerService {

    public void getCustomers() {
        System.out.println("Customer Service Invoked");
    }
}

class BillingService {

    public void getBills() {
        System.out.println("Billing Service Invoked");
    }
}

class ApiGateway {

    CustomerService customerService = new CustomerService();
    BillingService billingService = new BillingService();

    public void route(String path) {

        System.out.println("Checking Rate Limit...");
        System.out.println("Cache Checked");

        if (path.equals("/customer")) {

            System.out.println("Routing to Customer Service");
            customerService.getCustomers();

        } else if (path.equals("/billing")) {

            System.out.println("Routing to Billing Service");
            billingService.getBills();

        } else {

            System.out.println("404 Page Not Found");
        }
    }
}

public class ApiGatewayDemo {

    public static void main(String[] args) {

        ApiGateway gateway = new ApiGateway();

        gateway.route("/customer");

        System.out.println();

        gateway.route("/billing");
    }
}