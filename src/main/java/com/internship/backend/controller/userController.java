package com.internship.backend.controller;

//import com.internship.backend.exception.userNotFoundException;
//import com.internship.backend.model.user;
//import com.internship.backend.repository.userRepo;

import com.internship.backend.model.user;
import com.internship.backend.service.userService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class userController {

    private userService userService;

    userController(userService userService){
        this.userService = userService;
    }

    @GetMapping(path="/users")
    public List<user> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(path = "/users/{id}")
    public user getOneUser(@PathVariable long id){
        return userService.getOneUser(id);
    }

    @PostMapping(path="/users")
    public user addUser(@RequestBody user newUser){
        return userService.newUser(newUser);
    }

    @PutMapping(path="/users/{id}")
    public user replaceUser(@RequestBody user newUser,@PathVariable long id){
        return userService.replaceUser(newUser,id);
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

}
