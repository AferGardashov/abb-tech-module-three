package az.abbtech.student.vehicle;

import org.springframework.stereotype.Component;

@Component(value = "ford")
public class Ford implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ford move");
    }
}
