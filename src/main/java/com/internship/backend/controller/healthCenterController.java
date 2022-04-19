package com.internship.backend.controller;

//import com.internship.backend.exception.healthCenterNotFoundException;
//import com.internship.backend.model.healthCenter;
//import com.internship.backend.repository.healthCenterRepo;

import com.internship.backend.model.healthCenter;
import com.internship.backend.service.healthCenterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//import java.util.List;

@RestController
public class healthCenterController {

    private healthCenterService healthCenterService;

    healthCenterController(healthCenterService healthCenterService){
        this.healthCenterService = healthCenterService;
    }

    @GetMapping(path = "/healthCenter")
    public List<healthCenter> getAllHealthCenter(){
        return healthCenterService.getAllHealthCenter();
    }

    @GetMapping(path = "/healthCenter/{id}")
    public healthCenter getOneHealthCenter(@PathVariable long id){
        return healthCenterService.getOneHealthCenter(id);
    }

    @PostMapping(path = "/healthCenter")
    public healthCenter addHealthCenter(@RequestBody healthCenter healthCenter){
        return healthCenterService.newHealthCenter(healthCenter);
    }

    @PutMapping(path="/healthCenter/{id}")
    public healthCenter replaceHealthCenter(@RequestBody healthCenter healthCenter,@PathVariable long id){
        return healthCenterService.replaceHealthCenter(healthCenter, id);
    }

    @DeleteMapping(path = "/healthCenter/{id}")
    public void deleteHealthCenter(@PathVariable long id){ healthCenterService.deleteHealthCenter(id);}

}
