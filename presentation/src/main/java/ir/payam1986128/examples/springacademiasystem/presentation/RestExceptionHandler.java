package ir.payam1986128.examples.springacademiasystem.presentation;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.exception.HandledException;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.exception.ExceptionDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ExceptionDto handleException(AuthenticationException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ExceptionDto handleException(AccessDeniedException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionDto handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ExceptionDto(
                ex.getClass().getSimpleName(),
                "Please correct your request",
                ex.getBindingResult().getAllErrors().stream()
                        .collect(Collectors.toMap(e -> ((FieldError) e).getField(), DefaultMessageSourceResolvable::getDefaultMessage))
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionDto handleException(EntityNotFoundException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HandledException.class)
    public ExceptionDto handleException(HandledException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionDto handleException(Exception ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }
}
