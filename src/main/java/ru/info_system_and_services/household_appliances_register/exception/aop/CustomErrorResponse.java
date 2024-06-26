package ru.info_system_and_services.household_appliances_register.exception.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustomErrorResponse {

    private String timestamp;
    private int status;
    private String error;
    private String path;

    public CustomErrorResponse(String message, HttpStatus status, WebRequest request) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = status.value();
        this.error = message;
        this.path = ((ServletWebRequest) request).getRequest().getRequestURI();
//        log.info("Received response with error: timestamp {} status {} error {} path {}", timestamp, status, error, path);
    }

}
