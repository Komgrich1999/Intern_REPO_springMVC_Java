package com.internship.backend.advice;

import com.internship.backend.exception.HealthCenterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.internship.backend.exception.PatientNotFoundException;

@ControllerAdvice
public class HealthCenterNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(HealthCenterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String healthCenterNotFoundException(HealthCenterNotFoundException exception){
        return exception.getMessage();
    }
}
