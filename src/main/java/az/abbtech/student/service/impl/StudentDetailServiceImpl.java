package az.abbtech.student.service.impl;

import az.abbtech.student.dto.req.ReqStudentDetailDto;
import az.abbtech.student.dto.resp.RespStudentDetailDto;
import az.abbtech.student.entity.StudentDetailEntity;
import az.abbtech.student.repository.StudentDetailRepository;
import az.abbtech.student.service.StudentDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

    StudentDetailRepository studentDetailRepository;

    public StudentDetailServiceImpl(StudentDetailRepository studentDetailRepository) {
        this.studentDetailRepository = studentDetailRepository;
    }

    @Override
    public void saveStudentDetail(ReqStudentDetailDto reqStudentDetailDto) {
        studentDetailRepository.save(reqStudentDetailDto);
    }

    @Override
    public List<RespStudentDetailDto> getStudentDetails() {
        return studentDetailRepository.findAll();
    }

    @Override
    public RespStudentDetailDto getStudentDetailById(int id) {
        return studentDetailRepository.findById(id);
    }

    @Override
    public void deleteStudentDetail(int id) {
        studentDetailRepository.deleteById(id);
    }

    @Override
    public void updateStudentDetail(ReqStudentDetailDto reqStudentDetailDto) {
        studentDetailRepository.update(reqStudentDetailDto);
    }
}
