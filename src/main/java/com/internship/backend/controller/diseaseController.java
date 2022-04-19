package com.internship.backend.controller;

//import com.internship.backend.exception.diseaseNotFoundException;
//import com.internship.backend.model.disease;
import com.internship.backend.model.disease;
import com.internship.backend.repository.diseaseRepo;

import com.internship.backend.service.diseaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//import java.util.List;

@RestController
public class diseaseController {

    private diseaseService diseaseService;

    diseaseController(diseaseService diseaseService){
        this.diseaseService = diseaseService;
    }

    @GetMapping(path = "/disease")
    public List<disease> getAllDisease(){
        return diseaseService.getAllDisease();
    }

    @GetMapping(path = "/disease/{id}")
    public disease getOneDisease(@PathVariable long id){
        return diseaseService.getOneDisease(id);
    }

    @PostMapping(path = "/disease")
    public disease addDisease(@RequestBody disease disease){
        return diseaseService.newDisease(disease);
    }

    @PutMapping(path = "/disease/{id}")
    public disease replaceDisease(@RequestBody disease disease,@PathVariable long id){
        return diseaseService.replaceDisease(disease , id);
    }

    @DeleteMapping(path = "/disease/{id}")
    public void deleteDisease(@PathVariable long id){ diseaseService.deleteDisease(id); }
}
