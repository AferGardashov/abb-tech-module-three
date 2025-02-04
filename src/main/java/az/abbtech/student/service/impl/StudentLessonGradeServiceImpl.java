package az.abbtech.student.service.impl;

import az.abbtech.student.dto.req.ReqStudentLessonGradeDto;
import az.abbtech.student.entity.StudentLessonGradeEntity;
import az.abbtech.student.repository.StudentLessonGradeRepository;
import az.abbtech.student.service.StudentLessonGradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLessonGradeServiceImpl implements StudentLessonGradeService {

    StudentLessonGradeRepository studentLessonGradeRepository;

    public StudentLessonGradeServiceImpl(StudentLessonGradeRepository studentLessonGradeRepository) {
        this.studentLessonGradeRepository = studentLessonGradeRepository;
    }

    @Override
    public void saveLessonGrade(ReqStudentLessonGradeDto lessonGrade) {
        studentLessonGradeRepository.save(lessonGrade);
    }

    @Override
    public List<ReqStudentLessonGradeDto> getLessonGrades() {
        return studentLessonGradeRepository.findAll();
    }

    @Override
    public ReqStudentLessonGradeDto getLessonGradeById(int id) {
        return studentLessonGradeRepository.findById(id);
    }

    @Override
    public void deleteLessonGrade(int id) {
        studentLessonGradeRepository.deleteById(id);
    }

    @Override
    public void updateLessonGrade(ReqStudentLessonGradeDto lessonGrade) {
        studentLessonGradeRepository.update(lessonGrade);
    }
}
