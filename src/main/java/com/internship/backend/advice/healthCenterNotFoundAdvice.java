package com.internship.backend.advice;

import com.internship.backend.exception.healthCenterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class healthCenterNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(healthCenterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String healthCenterNotFoundException(healthCenterNotFoundException exception){
        return exception.getMessage();
    }
}
