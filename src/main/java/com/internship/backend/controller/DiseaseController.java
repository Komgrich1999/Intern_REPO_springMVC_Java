package com.internship.backend.controller;

import com.internship.backend.exception.DiseaseNotFoundException;
import com.internship.backend.model.Disease;
import com.internship.backend.repository.Disease_Repo;

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
public class DiseaseController {

    private final Disease_Repo disease_repo;

    DiseaseController(Disease_Repo disease_repo){
        this.disease_repo = disease_repo;
    }

    @GetMapping(path = "/disease")
    List<Disease> getAllDisease(){
        return disease_repo.findAll();
    }

    @GetMapping(path = "/disease/{id}")
    Disease getOneDisease(@PathVariable long id){
        return disease_repo.findById(id).orElseThrow(() -> new DiseaseNotFoundException(id));
    }

    @PostMapping(path = "/disease")
    Disease newDisease(@RequestBody Disease newDisease){ return disease_repo.save(newDisease); }

    @PutMapping(path = "/disease/{id}")
    Disease replaceDisease(@RequestBody Disease newDisease,@PathVariable long id){
        return disease_repo.findById(id).map(
                Disease -> {
                    Disease.setDisease_name(newDisease.getDisease_name());
                    Disease.setFILE_LOCATION(newDisease.getFILE_LOCATION());
                    return disease_repo.save(Disease);
                }
        ).orElseGet(() -> {
           newDisease.setDisease_ID(id);
           return disease_repo.save(newDisease);
        });
    }

    @DeleteMapping(path = "/disease/{id}")
    void deleteDisease(@PathVariable long id){ disease_repo.deleteById(id); }
}
