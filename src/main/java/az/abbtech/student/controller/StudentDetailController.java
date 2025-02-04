package az.abbtech.student.controller;

import az.abbtech.student.dto.req.ReqStudentDetailDto;
import az.abbtech.student.dto.resp.RespStudentDetailDto;
import az.abbtech.student.entity.StudentDetailEntity;
import az.abbtech.student.service.StudentDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-detail")
public class StudentDetailController {

    private final StudentDetailService studentDetailService;

    public StudentDetailController(StudentDetailService studentDetailService) {
        this.studentDetailService = studentDetailService;
    }


    @PostMapping("/post")
    public void save(@RequestBody ReqStudentDetailDto studentDetailDto) {
        studentDetailService.saveStudentDetail(studentDetailDto);
    }

    @GetMapping("/get")
    public List<RespStudentDetailDto> getAll() {
        return studentDetailService.getStudentDetails();
    }

    @GetMapping("/get/{id}")
    public RespStudentDetailDto getById(@PathVariable int id) {
        return studentDetailService.getStudentDetailById(id);
    }

    @PutMapping("/put")
    public void update(@RequestBody ReqStudentDetailDto studentDetailDto) {
        studentDetailService.updateStudentDetail(studentDetailDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentDetailService.deleteStudentDetail(id);
    }
}
