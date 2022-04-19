package com.internship.backend.advice;


import com.internship.backend.exception.userNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class userNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(userNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(userNotFoundException exception){
        return exception.getMessage();
    }
}
