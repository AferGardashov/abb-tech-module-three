package az.abbtech.student.bean;

import org.springframework.context.annotation.Configuration;


/**
  Annotation based bean configuration
**/
@Configuration
public class Student {
    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
