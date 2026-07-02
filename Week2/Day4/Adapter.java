class Adapter {

    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        paypal.processPayment(1000);
        stripe.processPayment(2000);
    }
}

interface PaymentProcessor{
    void processPayment(double amount);
}

class PayPalGateway{
    public void makePayment(double amount){
        System.out.println("PayPal payment: " + amount);
    }
}

class StripeGateway{
    public void payAmount(double amount){
        System.out.println("Stripe payment: " + amount);
    }
}

class PayPalAdapter implements PaymentProcessor{

    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal){
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount){
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor{

    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe){
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount){
        stripe.payAmount(amount);
    }
}