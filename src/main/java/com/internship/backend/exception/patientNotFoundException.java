package com.internship.backend.exception;

public class patientNotFoundException extends RuntimeException{

    public patientNotFoundException(long id){
        super("Could not found this Patient with this HN ===> " + id);
    }
}
