package com.internship.backend.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.internship.backend.exception.patientNotFoundException;

@ControllerAdvice
public class patientNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(patientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String patientNotFoundHandler(patientNotFoundException exception){
        return exception.getMessage();
    }
}
