package az.abbtech.student.vehicle;

import org.springframework.stereotype.Component;

@Component(value = "toyota")
public class Toyota implements Vehicle {
    @Override
    public void move() {
        System.out.println("Toyota move");
    }
}
