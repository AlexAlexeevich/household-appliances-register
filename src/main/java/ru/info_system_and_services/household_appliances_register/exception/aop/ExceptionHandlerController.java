package ru.info_system_and_services.household_appliances_register.exception.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import ru.info_system_and_services.household_appliances_register.exception.SuchModelAlreadyExistException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(SuchModelAlreadyExistException.class)
    public ResponseEntity<CustomErrorResponse> handleCardStatusNotActiveException(SuchModelAlreadyExistException e,
                                                                                  WebRequest request) {
        CustomErrorResponse customErrorResponse = buildErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST, request);
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private CustomErrorResponse buildErrorResponse(String message, HttpStatus status, WebRequest request) {
        return new CustomErrorResponse(
                LocalDateTime.now().toString(),
                status.value(),
                message,
                ((ServletWebRequest) request).getRequest().getRequestURI());
    }
}
