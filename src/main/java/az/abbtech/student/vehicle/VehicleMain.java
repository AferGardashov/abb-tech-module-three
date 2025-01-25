package az.abbtech.student.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleMain {

    private Vehicle vehicle;

    public VehicleMain(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Autowired
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void getVehicle() {
        System.out.println(vehicle + " is moving");;
    }
}
