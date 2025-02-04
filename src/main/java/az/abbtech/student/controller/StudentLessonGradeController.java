package az.abbtech.student.controller;

import az.abbtech.student.dto.req.ReqStudentLessonGradeDto;
import az.abbtech.student.dto.resp.RespStudentLessonGradeDto;
import az.abbtech.student.entity.StudentLessonGradeEntity;
import az.abbtech.student.service.StudentLessonGradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-lesson-grade")
public class StudentLessonGradeController {


    private final StudentLessonGradeService studentLessonGradeService;

    public StudentLessonGradeController(StudentLessonGradeService studentLessonGradeService) {
        this.studentLessonGradeService = studentLessonGradeService;
    }

    @PostMapping("/post")
    public void save(@RequestBody ReqStudentLessonGradeDto studentLessonGradeDto) {
        studentLessonGradeService.saveLessonGrade(studentLessonGradeDto);
    }

    @GetMapping("/get")
    public List<RespStudentLessonGradeDto> findAll() {
        return studentLessonGradeService.getLessonGrades();
    }

    @GetMapping("/get/{id}")
    public RespStudentLessonGradeDto findById(@PathVariable int id) {
        return studentLessonGradeService.getLessonGradeById(id);
    }

    @PutMapping("put")
    public void update(@RequestBody ReqStudentLessonGradeDto studentLessonGradeDto) {
        studentLessonGradeService.updateLessonGrade(studentLessonGradeDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentLessonGradeService.deleteLessonGrade(id);
    }
}
