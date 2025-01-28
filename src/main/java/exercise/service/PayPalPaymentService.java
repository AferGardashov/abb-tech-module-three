package exercise.service;

import org.springframework.stereotype.Component;

@Component(value = "paypal")
public class PayPalPaymentService implements PaymentService {

    {
        System.out.println("PayPalPaymentService");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal payment is processed!" + amount);
    }
}
