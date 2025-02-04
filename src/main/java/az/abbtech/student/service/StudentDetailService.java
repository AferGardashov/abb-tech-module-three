package az.abbtech.student.service;

import az.abbtech.student.dto.req.ReqStudentDetailDto;
import az.abbtech.student.dto.resp.RespStudentDetailDto;
import az.abbtech.student.entity.StudentDetailEntity;

import java.util.List;

public interface StudentDetailService {

    void saveStudentDetail(ReqStudentDetailDto studentDetail);

    List<RespStudentDetailDto> getStudentDetails();

    RespStudentDetailDto getStudentDetailById(int id);

    void deleteStudentDetail(int id);

    void updateStudentDetail(ReqStudentDetailDto studentDetail);
}
