package az.abbtech.student.repository;

import az.abbtech.student.entity.StudentLessonGradeEntity;

import java.util.List;

public interface StudentLessonGradeRepository {

    void save(StudentLessonGradeEntity studentLessonGrade);

    List<StudentLessonGradeEntity> findAll();

    StudentLessonGradeEntity findById(int id);

    void deleteById(int id);

    void update(StudentLessonGradeEntity studentLessonGrade);

}
