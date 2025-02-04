package az.abbtech.student.service;

import az.abbtech.student.dto.req.ReqStudentDto;
import az.abbtech.student.dto.resp.RespStudentDto;

import java.util.List;

public interface StudentService {

    void saveStudent(ReqStudentDto reqStudentDto);

    List<RespStudentDto> getStudents();

    RespStudentDto getStudentById(int id);

    void deleteStudentById(int id);

    void updateStudent(ReqStudentDto reqStudentDto, int id);
}
