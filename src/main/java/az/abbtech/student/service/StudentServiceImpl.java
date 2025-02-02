package az.abbtech.student.service;

import az.abbtech.student.dto.ReqStudentDto;
import az.abbtech.student.dto.RespStudentDto;
import az.abbtech.student.entity.StudentEntity;
import az.abbtech.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(ReqStudentDto reqStudentDto) {
        studentRepository.saveStudent(new StudentEntity(reqStudentDto.name(),
                reqStudentDto.score(),
                reqStudentDto.username(),
                reqStudentDto.password()));
    }

    @Override
    public List<RespStudentDto> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentEntity -> new RespStudentDto(studentEntity.getId()
                        , studentEntity.getName()
                        , studentEntity.getScore()
                        , studentEntity.getUsername()))
                .toList();
    }

    @Override
    public RespStudentDto getStudentById(int id) {
        var studentEntity = studentRepository.findById(id);
        return new RespStudentDto(studentEntity.getId()
                , studentEntity.getName()
                , studentEntity.getScore()
                , studentEntity.getUsername());
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(ReqStudentDto reqStudentDto, int id) {
        studentRepository.update(new StudentEntity(id
                , reqStudentDto.name()
                , reqStudentDto.score()
                , reqStudentDto.username()
                , reqStudentDto.password()));
    }
}
