package com.internship.backend.controller;

import com.internship.backend.exception.HealthCenterNotFoundException;
import com.internship.backend.model.Health_Center;
import com.internship.backend.repository.Health_Center_Repo;

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
public class HealthCenterController {

    private final Health_Center_Repo hc_repo;

    HealthCenterController(Health_Center_Repo hc_repo) {
        this.hc_repo = hc_repo;
    }

    @GetMapping(path = "/healthCenter")
    List<Health_Center> getAllHealthCenter(){
        return hc_repo.findAll();
    }

    @GetMapping(path = "/healthCenter/{id}")
    Health_Center getOneHealthCenter(@PathVariable long id){
        return hc_repo.findById(id).orElseThrow(() -> new HealthCenterNotFoundException(id));
    }

    @PostMapping(path = "/healthCenter")
    Health_Center newHealthCenter(@RequestBody Health_Center newHealthCenter){
        return hc_repo.save(newHealthCenter);
    }

    @PutMapping(path="/healthCenter/{id}")
    Health_Center replaceHealthCenter(@RequestBody Health_Center newHealthCenter,@PathVariable long id){
        return hc_repo.findById(id).map(
                Health_Center -> {
                    Health_Center.setHC_name(newHealthCenter.getHC_name());
                    Health_Center.setHC_town(newHealthCenter.getHC_town());
                    return hc_repo.save(Health_Center);
                }
        ).orElseGet(() -> {
            newHealthCenter.setHC_ID(id);
            return hc_repo.save(newHealthCenter);
        });
    }

    @DeleteMapping(path = "/healthCenter/{id}")
    void deleteHealthCenter(@PathVariable long id) {
        hc_repo.deleteById(id);
    }

}
