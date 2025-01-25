package az.abbtech.student.vehicle;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "chevrolet")
public class Chevrolet implements Vehicle {

    @Override
    public void move() {
        System.out.println("Chevrolet move");
    }
}
