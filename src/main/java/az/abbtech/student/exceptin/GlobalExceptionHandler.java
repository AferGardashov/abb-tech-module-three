package az.abbtech.student.exceptin;

import az.abbtech.student.dto.BaseExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public ResponseEntity<BaseExceptionDto> handleException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseExceptionDto(ex.getMessage()));
    }
}
