package com.internship.backend.service;

import com.internship.backend.exception.healthCenterNotFoundException;
import com.internship.backend.model.healthCenter;
import com.internship.backend.repository.healthCenterRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class healthCenterService {

    private final healthCenterRepo healthCenterRepo;

    healthCenterService(healthCenterRepo healthCenterRepo){
        this.healthCenterRepo = healthCenterRepo;
    }

    public List<healthCenter> getAllHealthCenter(){
        return healthCenterRepo.findAll();
    }

    public healthCenter getOneHealthCenter(long id){
        return healthCenterRepo.findById(id).orElseThrow(() -> new healthCenterNotFoundException(id));
    }

    public healthCenter newHealthCenter(healthCenter newHealthCenter){
        return healthCenterRepo.save(newHealthCenter);
    }

    public healthCenter replaceHealthCenter(healthCenter newHealthCenter,long id){
        return healthCenterRepo.findById(id).map(
                Health_Center -> {
                    Health_Center.setHC_name(newHealthCenter.getHC_name());
                    Health_Center.setHC_town(newHealthCenter.getHC_town());
                    return healthCenterRepo.save(Health_Center);
                }
        ).orElseGet(() -> {
            newHealthCenter.setHC_ID(id);
            return healthCenterRepo.save(newHealthCenter);
        });
    }

    public void deleteHealthCenter(@PathVariable long id) {
        healthCenterRepo.deleteById(id);
    }

}
