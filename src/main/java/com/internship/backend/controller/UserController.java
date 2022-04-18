package com.internship.backend.controller;

import com.internship.backend.exception.UserNotFoundException;
import com.internship.backend.model.User;
import com.internship.backend.repository.User_Repo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final User_Repo user_repo;

    UserController(User_Repo user_repo){
        this.user_repo = user_repo;
    }

    @GetMapping(path="/users")
    List<User> getAllUser(){
        return user_repo.findAll();
    }

    @GetMapping(path = "/users/{id}")
    User getOneUser(@PathVariable long id){
        return user_repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping(path="/users")
    User newUser(@RequestBody User newUser){
        return user_repo.save(newUser);
    }

    @PutMapping(path="/users/{id}")
    User replaceUser(@RequestBody User newUser,@PathVariable long id){
        return user_repo.findById(id).map(
                User -> {
                    User.setPassword(newUser.getPassword());
                    return user_repo.save(User);
                }
        ).orElseGet(() -> {
            newUser.setID(id);
            return user_repo.save(newUser);
        });
    }

    @DeleteMapping(path="/users/{id}")
    void deleteUser(@PathVariable long id){
        user_repo.deleteById(id);
    }
}
