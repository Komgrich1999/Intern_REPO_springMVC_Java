package com.internship.backend.exception;

public class DiseaseNotFoundException extends RuntimeException {
    public DiseaseNotFoundException(long id){
        super("Could not found this Disease with id ===> " + id);
    }
}
