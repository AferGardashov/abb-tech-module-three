package az.abbtech.student.service.impl;

import az.abbtech.student.dto.req.ReqStudentClassDto;
import az.abbtech.student.dto.resp.RespStudentClassDto;
import az.abbtech.student.entity.StudentClassEntity;
import az.abbtech.student.repository.StudentClassRepository;
import az.abbtech.student.service.StudentClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassServiceImpl implements StudentClassService {

    StudentClassRepository studentClassRepository;

    public StudentClassServiceImpl(StudentClassRepository studentClassRepository) {
        this.studentClassRepository = studentClassRepository;
    }

    @Override
    public void saveStudentClass(ReqStudentClassDto reqStudentClassDto) {
        studentClassRepository.save(
                new StudentClassEntity(reqStudentClassDto.studentId(), reqStudentClassDto.classId()));
    }

    @Override
    public List<RespStudentClassDto> getStudentClasses() {
        return studentClassRepository.findAll().stream()
                .map(studentClassEntity-> new RespStudentClassDto(studentClassEntity.getId()
                        , studentClassEntity.getStudentId()
                        , studentClassEntity.getClassId()))
                .toList();
    }

    @Override
    public RespStudentClassDto getStudentClassById(int id) {
        var response = studentClassRepository.findById(id);
        return new RespStudentClassDto(response.getId(), response.getStudentId(), response.getClassId());
    }

    @Override
    public void deleteStudentClass(int id) {
        studentClassRepository.delete(id);
    }

    @Override
    public void updateStudentClass(ReqStudentClassDto reqStudentClassDto) {
        studentClassRepository.update(new StudentClassEntity(reqStudentClassDto.studentId(), reqStudentClassDto.classId()));
    }
}
