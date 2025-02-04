package az.abbtech.student.repository;

import az.abbtech.student.entity.StudentClassEntity;

import java.util.List;

public interface StudentClassRepository {

    void save(StudentClassEntity studentClass);

    StudentClassEntity findById(int id);

    List<StudentClassEntity> findAll();

    void delete(int id);

    void update(StudentClassEntity studentClass);

}
