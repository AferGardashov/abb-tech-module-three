package az.abbtech.student.vehicle;

import org.springframework.stereotype.Component;

@Component
public class Toyota implements Vehicle {
    @Override
    public void move() {
        System.out.println("Toyota move");
    }
}
