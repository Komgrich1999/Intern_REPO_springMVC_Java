package com.internship.backend.exception;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(long id){
        super("Could not found this Patient with this HN ===> " + id);
    }
}
