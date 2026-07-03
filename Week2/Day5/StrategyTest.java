interface PaymentStrategy {
    void pay(int amount);
}

// Credit Card Strategy
class CreditCardPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card");
    }
}

// PayPal Strategy
class PayPalPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using PayPal");
    }
}

// Context Class
class PaymentContext {

    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(int amount) {
        strategy.pay(amount);
    }
}

// Main Class
public class StrategyTest {

    public static void main(String[] args) {

        PaymentContext payment = new PaymentContext();

        payment.setPaymentStrategy(new CreditCardPayment());
        payment.makePayment(1000);

        payment.setPaymentStrategy(new PayPalPayment());
        payment.makePayment(500);
    }
}
