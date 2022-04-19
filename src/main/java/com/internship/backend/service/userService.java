package com.internship.backend.service;

import com.internship.backend.exception.userNotFoundException;
import com.internship.backend.model.user;
import com.internship.backend.repository.userRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class userService {

    private final userRepo userRepo;

    userService(userRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<user> getAllUser(){
        return userRepo.findAll();
    }

    public user getOneUser(long id){
        return userRepo.findById(id).orElseThrow(() -> new userNotFoundException(id));
    }

    public user newUser(user newUser){
        return userRepo.save(newUser);
    }

    public user replaceUser(user newUser,long id){
        return userRepo.findById(id).map(
                User -> {
                    User.setPassword(newUser.getPassword());
                    return userRepo.save(User);
                }
        ).orElseGet(() -> {
            newUser.setID(id);
            return userRepo.save(newUser);
        });
    }

    public void deleteUser(@PathVariable long id){
        userRepo.deleteById(id);
    }

}
