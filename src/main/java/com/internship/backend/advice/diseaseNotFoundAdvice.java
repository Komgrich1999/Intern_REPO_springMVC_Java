package com.internship.backend.advice;

import com.internship.backend.exception.diseaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class diseaseNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(diseaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String diseaseNotFoundHandler(diseaseNotFoundException exception){

        return exception.getMessage();
    }
}
