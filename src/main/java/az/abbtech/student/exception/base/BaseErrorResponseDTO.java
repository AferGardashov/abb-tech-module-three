package az.abbtech.student.exception.base;

/**
 * Data transfer object representing an error response.
 * Contains information about the error such as code, message, and path,
 * along with optional additional data.
 *
 * @param code      The unique error code.
 * @param message   The error message.
 * @param path      The path where the error occurred.
 * @param timestamp Timestamp
 * @param data      Additional data related to the error (optional).
 */

public record BaseErrorResponseDTO(String code, String message, String path, String timestamp,
                                   Integer status, Object... data) {
}

// ABB-TECH-STUDENT-BIZ-001
// USER_NOT_FOUND// Istifadechi tapilmadi
// /students
// 29-01-2025 :10:40:-5
//{ "data": {"username":"cavidan","class":"sadsadas"}}