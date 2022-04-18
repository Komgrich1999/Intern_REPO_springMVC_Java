package com.internship.backend.advice;

import com.internship.backend.exception.DiseaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DiseaseNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DiseaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String diseaseNotFoundHandler(DiseaseNotFoundException exception){

        return exception.getMessage();
    }
}
