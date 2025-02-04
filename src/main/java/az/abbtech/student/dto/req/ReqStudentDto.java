package az.abbtech.student.dto.req;


import java.math.BigDecimal;

public record ReqStudentDto(String name, BigDecimal score, String username, String password) {
}
