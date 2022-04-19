package com.internship.backend.exception;

public class healthCenterNotFoundException extends RuntimeException {
    public healthCenterNotFoundException(long id){
        super("Could not found this Health Center with id ===> " + id);
    }
}
