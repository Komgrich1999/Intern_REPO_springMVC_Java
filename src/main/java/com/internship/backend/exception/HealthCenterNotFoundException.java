package com.internship.backend.exception;

public class HealthCenterNotFoundException extends RuntimeException {
    public HealthCenterNotFoundException(long id){
        super("Could not found this Health Center with id ===> " + id);
    }
}
