package az.abbtech.student.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedBean {

    @Bean("employee1")
    public Employee getEmployee1() {
        return new Employee(1,"Employee 1");
    }

    @Bean("employee2")
    public Employee getEmployee2() {
        return new Employee(2,"Employee 2");
    }

    @Bean("employee3")
    public Employee getEmployee3() {
        return new Employee(3,"Employee 3");
    }
}
