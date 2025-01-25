package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.service.PaymentService;

import java.util.Map;

@Component
public class PaymentProcessor {

    {
        System.out.println("PaymentProcessor");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private final Map<String, PaymentService> paymentServices;


    @Autowired
    public PaymentProcessor(Map<String, PaymentService> paymentServices) {
        this.paymentServices = paymentServices;
        System.out.println("Dependency Injection");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pay(String paymentMethod, double amount) {
        PaymentService paymentService = paymentServices.get(paymentMethod);
        if(paymentService == null) {
            System.out.println("Payment service" + paymentMethod + " not found");
        }else{
            paymentService.processPayment(amount);
        }
    }
}
