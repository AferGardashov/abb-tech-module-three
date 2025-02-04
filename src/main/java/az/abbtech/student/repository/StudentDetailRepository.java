package az.abbtech.student.repository;

import az.abbtech.student.entity.StudentDetailEntity;

import java.util.List;

public interface StudentDetailRepository {

    void save(StudentDetailEntity studentDetailEntity);

    List<StudentDetailEntity> findAll();

    StudentDetailEntity findById(int id);

    void deleteById(int id);

    void update(StudentDetailEntity studentDetailEntity);
}
