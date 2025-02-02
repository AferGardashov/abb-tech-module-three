package az.abbtech.student.repository;

import az.abbtech.student.entity.StudentEntity;

import java.util.List;

public interface StudentRepository {

    void saveStudent(StudentEntity student);

    List<StudentEntity> findAll();

    StudentEntity findById(int id);

    void deleteById(int id);

    void update(StudentEntity student);
}
