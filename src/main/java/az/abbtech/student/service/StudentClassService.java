package az.abbtech.student.service;

import az.abbtech.student.dto.req.ReqStudentClassDto;
import az.abbtech.student.dto.resp.RespStudentClassDto;
import az.abbtech.student.entity.ClassEntity;
import az.abbtech.student.entity.StudentClassEntity;

import java.util.List;

public interface StudentClassService {

    void saveStudentClass(ReqStudentClassDto studentClass);

    List<RespStudentClassDto> getStudentClasses();

    RespStudentClassDto getStudentClassById(int id);

    void deleteStudentClass(int id);

    void updateStudentClass(ReqStudentClassDto studentClass);
}
