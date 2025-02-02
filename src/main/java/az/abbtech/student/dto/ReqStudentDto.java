package az.abbtech.student.dto;


import java.math.BigDecimal;

public record ReqStudentDto(String name, BigDecimal score, String username, String password) {
}
