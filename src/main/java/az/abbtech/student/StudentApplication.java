package az.abbtech.student;

import az.abbtech.student.bean.Employee;
import az.abbtech.student.bean.Student;
import az.abbtech.student.vehicle.VehicleMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(StudentApplication.class, args);
        Student student = context.getBean(Student.class);
        System.out.println(student.getName());

        Employee employee = context.getBean("employee1", Employee.class);
        System.out.println(employee.getName());

        VehicleMain vehicle = context.getBean(VehicleMain.class);
        vehicle.getVehicle();
    }

}
