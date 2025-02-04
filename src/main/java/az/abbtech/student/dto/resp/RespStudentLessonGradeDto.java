package az.abbtech.student.dto.resp;

import java.math.BigDecimal;

public record RespStudentLessonGradeDto(int id, BigDecimal grade, int studentId) {
}
