package az.abbtech.student.controller;

import az.abbtech.student.dto.req.ReqClassDto;
import az.abbtech.student.dto.req.ReqStudentClassDto;
import az.abbtech.student.dto.req.ReqStudentDto;
import az.abbtech.student.dto.resp.RespStudentClassDto;
import az.abbtech.student.entity.StudentClassEntity;
import az.abbtech.student.service.StudentClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-class")
public class StudentClassController {

    private final StudentClassService studentClassService;

    public StudentClassController(StudentClassService studentClassService) {
        this.studentClassService = studentClassService;
    }

    @PostMapping("/post")
    public void save(@RequestBody ReqStudentClassDto studentClass) {
        studentClassService.saveStudentClass(studentClass);
    }

    @GetMapping("/get")
    public List<RespStudentClassDto> getAll() {
        return studentClassService.getStudentClasses();
    }

    @GetMapping("/get/{id}")
    public RespStudentClassDto getById(@PathVariable int id) {
        return studentClassService.getStudentClassById(id);
    }

    @PutMapping("/put/{id}")
    public void update(@RequestBody ReqStudentClassDto studentClass, @PathVariable int id) {
        studentClassService.updateStudentClass(studentClass);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentClassService.deleteStudentClass(id);
    }
}
