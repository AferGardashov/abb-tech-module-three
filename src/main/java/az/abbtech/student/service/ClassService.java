package az.abbtech.student.service;

import az.abbtech.student.dto.req.ReqClassDto;
import az.abbtech.student.dto.resp.RespClassDto;
import az.abbtech.student.entity.ClassEntity;

import java.util.List;

public interface ClassService {

    void saveClass(ReqClassDto reqClassDto);

    List<RespClassDto> getClasses();

    RespClassDto getClassById(int id);

    void deleteClass(int id);

    void updateClass(ReqClassDto reqClassDto);
}
