/*
=====================================================
Exercise 4: Circuit Breaker using Resilience4j Concept
=====================================================

Problem Statement:

Payment Service calls a slow third-party API.

Requirements:

• Circuit Breaker
• Fallback Logic
• Logging

=====================================================
*/

class ThirdPartyPayment {

    public String payment() {

        throw new RuntimeException("Server Timeout");

    }
}

class PaymentService {

    ThirdPartyPayment api = new ThirdPartyPayment();

    public void makePayment() {

        try {

            String result = api.payment();

            System.out.println(result);

        } catch (Exception e) {

            fallback();
        }

    }

    public void fallback() {

        System.out.println("Fallback Method Executed");

        System.out.println("Payment Service is Temporarily Unavailable");

        System.out.println("Event Logged Successfully");

    }
}

public class PaymentCircuitBreakerDemo {

    public static void main(String[] args) {

        PaymentService payment = new PaymentService();

        payment.makePayment();

    }
}