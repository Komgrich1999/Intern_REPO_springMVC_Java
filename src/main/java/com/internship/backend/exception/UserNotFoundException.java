package com.internship.backend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id){
        super("Could not found this User with this id ===> " + id);
    }
}
