package az.abbtech.student.service;

import az.abbtech.student.dto.req.ReqStudentLessonGradeDto;
import az.abbtech.student.dto.resp.RespStudentLessonGradeDto;

import java.util.List;

public interface StudentLessonGradeService {

    void saveLessonGrade(ReqStudentLessonGradeDto lessonGrade);

    List<RespStudentLessonGradeDto> getLessonGrades();

    RespStudentLessonGradeDto getLessonGradeById(int id);

    void deleteLessonGrade(int id);

    void updateLessonGrade(ReqStudentLessonGradeDto lessonGrade);

}
