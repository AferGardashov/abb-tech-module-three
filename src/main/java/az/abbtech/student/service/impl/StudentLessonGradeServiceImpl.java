package az.abbtech.student.service.impl;

import az.abbtech.student.dto.req.ReqStudentLessonGradeDto;
import az.abbtech.student.dto.resp.RespStudentLessonGradeDto;
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
        studentLessonGradeRepository.save(new StudentLessonGradeEntity(lessonGrade.grade(), lessonGrade.studentId()));
    }

    @Override
    public List<RespStudentLessonGradeDto> getLessonGrades() {
        return studentLessonGradeRepository.findAll().stream().map(studentLessonGradeEntity -> new RespStudentLessonGradeDto(
                studentLessonGradeEntity.getId()
                , studentLessonGradeEntity.getGrade()
                , studentLessonGradeEntity.getStudentId())
        ).toList();
    }

    @Override
    public RespStudentLessonGradeDto getLessonGradeById(int id) {
        var studentLessonGradeEntity = studentLessonGradeRepository.findById(id);
        return new RespStudentLessonGradeDto(studentLessonGradeEntity.getId()
                , studentLessonGradeEntity.getGrade()
                , studentLessonGradeEntity.getStudentId());
    }

    @Override
    public void deleteLessonGrade(int id) {
        studentLessonGradeRepository.deleteById(id);
    }

    @Override
    public void updateLessonGrade(ReqStudentLessonGradeDto lessonGrade) {
        studentLessonGradeRepository.update(new StudentLessonGradeEntity(lessonGrade.grade(), lessonGrade.studentId()));
    }
}
