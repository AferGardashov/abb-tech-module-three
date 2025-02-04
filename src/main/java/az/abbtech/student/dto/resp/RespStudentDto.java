package az.abbtech.student.dto.resp;

import java.math.BigDecimal;

public record RespStudentDto(int id, String name, BigDecimal score, String username) {
}
