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
        studentDetailRepository.save(new StudentDetailEntity(reqStudentDetailDto.address()
                , reqStudentDetailDto.phone()
                , reqStudentDetailDto.city()
                , reqStudentDetailDto.studentId()));
    }

    @Override
    public List<RespStudentDetailDto> getStudentDetails() {
        return studentDetailRepository.findAll().stream().map(studentDetailEntity -> new RespStudentDetailDto(
                studentDetailEntity.getId()
                , studentDetailEntity.getAddress()
                , studentDetailEntity.getPhone()
                , studentDetailEntity.getCity()
                , studentDetailEntity.getStudentId()
        )).toList();
    }

    @Override
    public RespStudentDetailDto getStudentDetailById(int id) {
        var studentDetailEntity = studentDetailRepository.findById(id);
        return new RespStudentDetailDto(studentDetailEntity.getId()
                , studentDetailEntity.getAddress()
                , studentDetailEntity.getPhone()
                , studentDetailEntity.getCity()
                , studentDetailEntity.getStudentId());
    }

    @Override
    public void deleteStudentDetail(int id) {
        studentDetailRepository.deleteById(id);
    }

    @Override
    public void updateStudentDetail(ReqStudentDetailDto reqStudentDetailDto) {
        studentDetailRepository.update(new StudentDetailEntity(
                reqStudentDetailDto.address()
                , reqStudentDetailDto.phone()
                , reqStudentDetailDto.city()
                , reqStudentDetailDto.studentId()));
    }
}
