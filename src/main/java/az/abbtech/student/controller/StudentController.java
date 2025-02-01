package az.abbtech.student.controller;

import az.abbtech.student.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {


    @GetMapping("/get/{name}/{surname}")
    public ResponseEntity<StudentDto> getStudent(
            @PathVariable String name,
            @PathVariable String surname,
            @RequestParam(required = false, defaultValue = "test") String email) {


        return ResponseEntity.status(HttpStatus.OK).
                body(new StudentDto(name, surname, email));
    }

    @PostMapping("/post")
    public void saveStudent(
            @RequestHeader("X-USER-ID") String userId,
            @RequestBody StudentDto studentDto) {

        System.out.println(studentDto);
        System.out.println(userId);
        throw new ArithmeticException("Arithmetic Error");
    }
}
