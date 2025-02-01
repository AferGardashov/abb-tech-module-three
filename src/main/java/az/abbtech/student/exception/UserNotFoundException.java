package az.abbtech.student.exception;


import az.abbtech.student.exception.base.BaseErrorService;
import az.abbtech.student.exception.base.BaseException;

/**
 * Exception class representing custom exceptions related to sample error cases.
 * Inherits from {@link BaseException}, allowing it to utilize error details
 * from {@link BaseErrorService} and optional additional arguments for flexible error message formatting.
 */
public class UserNotFoundException extends BaseException {

    /**
     * Constructor for {@link UserNotFoundException} with a throwable and additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param throwable        The root cause of the exception.
     * @param args             Additional arguments for the error.
     */
    public UserNotFoundException(BaseErrorService baseErrorService, Throwable throwable, Object... args) {
        super(baseErrorService, throwable, args);
    }

    /**
     * Constructor for {@link UserNotFoundException} with additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param args             Additional arguments for the error.
     */
    public UserNotFoundException(BaseErrorService baseErrorService, Object... args) {
        super(baseErrorService, args);
    }


}

