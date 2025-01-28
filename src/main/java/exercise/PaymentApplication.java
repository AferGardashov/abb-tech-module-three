package exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {

    private final PaymentProcessor paymentProcessor;

    @Autowired
    public PaymentApplication(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PaymentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available payments: credit, bank, paypal");
        System.out.println("Enter your payment method: ");
        String paymentMethod = scanner.nextLine();
        System.out.println("Enter your payment amount: ");
        double amount = scanner.nextDouble();

        paymentProcessor.pay(paymentMethod, amount);

    }
}