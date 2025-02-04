package az.abbtech.student.service.impl;

import az.abbtech.student.dto.req.ReqClassDto;
import az.abbtech.student.dto.resp.RespClassDto;
import az.abbtech.student.entity.ClassEntity;
import az.abbtech.student.repository.ClassRepository;
import az.abbtech.student.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void saveClass(ReqClassDto reqClassDto) {
        classRepository.save(new ClassEntity(reqClassDto.name()));
    }

    @Override
    public List<RespClassDto> getClasses() {
        return classRepository.findAll().stream()
                .map(classEntity -> new RespClassDto(classEntity.getId(), classEntity.getName()))
                .toList();
    }

    @Override
    public RespClassDto getClassById(int id) {
        var classEntity = classRepository.findById(id);
        return new RespClassDto(classEntity.getId(), classEntity.getName());
    }

    @Override
    public void deleteClass(int id) {
        classRepository.delete(id);
    }

    @Override
    public void updateClass(ReqClassDto reqClassDto) {
        classRepository.update(new ClassEntity(reqClassDto.name()));
    }
}
