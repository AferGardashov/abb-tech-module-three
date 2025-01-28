package exercise.service;

import org.springframework.stereotype.Component;

@Component(value = "credit")
public class CreditCardPaymentService implements PaymentService {

    {
        System.out.println("CreditCardPaymentService");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit card payment processed: " + amount);
    }
}
