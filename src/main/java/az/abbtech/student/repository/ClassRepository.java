package az.abbtech.student.repository;

import az.abbtech.student.entity.ClassEntity;

import java.util.List;

public interface ClassRepository {

    void save(ClassEntity classEntity);

    List<ClassEntity> findAll();

    ClassEntity findById(int id);

    void delete(int id);

    void update(ClassEntity classEntity);
}
