package com.internship.backend.exception;

public class diseaseNotFoundException extends RuntimeException {
    public diseaseNotFoundException(long id){
        super("Could not found this Disease with id ===> " + id);
    }
}
