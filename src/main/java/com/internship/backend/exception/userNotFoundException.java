package com.internship.backend.exception;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(long id){
        super("Could not found this User with this id ===> " + id);
    }
}
