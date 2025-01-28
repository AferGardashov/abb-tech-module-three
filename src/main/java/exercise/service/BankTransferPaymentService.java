package exercise.service;

import org.springframework.stereotype.Component;

@Component(value = "bank")
public class BankTransferPaymentService implements PaymentService {

    {
        System.out.println("BankTransferPaymentService");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Bank Transfer Payment" + amount);
    }
}
