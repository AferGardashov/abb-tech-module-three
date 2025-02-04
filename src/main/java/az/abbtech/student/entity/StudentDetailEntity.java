package az.abbtech.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String phone;
    private String city;
    private int studentId;

    public StudentDetailEntity(String address, String phone, String city, int studentId) {
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.studentId = studentId;
    }
}
