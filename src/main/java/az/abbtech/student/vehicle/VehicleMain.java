package az.abbtech.student.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleMain {

    private Vehicle vehicle;

    @Autowired
    public VehicleMain(@Qualifier("ford") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void getVehicle() {
        vehicle.move();
    }
}
