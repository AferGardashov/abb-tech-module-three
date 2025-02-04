package az.abbtech.student.controller;

import az.abbtech.student.dto.req.ReqStudentDto;
import az.abbtech.student.dto.resp.RespStudentDto;
import az.abbtech.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/post")
    public void save(@RequestBody ReqStudentDto reqStudentDto) {
        studentService.saveStudent(reqStudentDto);
    }

    @GetMapping("/get")
    public List<RespStudentDto> getAll() {
        return studentService.getStudents();
    }

    @GetMapping("/get/{id}")
    public RespStudentDto getById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/put/{id}")
    public void update(@RequestBody ReqStudentDto reqStudentDto, @PathVariable int id) {
        studentService.updateStudent(reqStudentDto, id);
    }
}
