package com.internship.backend.service;

import com.internship.backend.exception.diseaseNotFoundException;
import com.internship.backend.model.disease;
import com.internship.backend.repository.diseaseRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class diseaseService {

    private diseaseRepo diseaseRepo;

    diseaseService(diseaseRepo diseaseRepo){
        this.diseaseRepo = diseaseRepo;
    }

    public List<disease> getAllDisease(){
        return diseaseRepo.findAll();
    }

    public disease getOneDisease(long id){
        return diseaseRepo.findById(id).orElseThrow(() -> new diseaseNotFoundException(id));
    }

    public disease newDisease(disease newDisease){ return diseaseRepo.save(newDisease); }

    public disease replaceDisease(disease newDisease,long id){
        return diseaseRepo.findById(id).map(
                Disease -> {
                    Disease.setDiseaseName(newDisease.getDiseaseName());
                    Disease.setFileLocation(newDisease.getFileLocation());
                    return diseaseRepo.save(Disease);
                }
        ).orElseGet(() -> {
            newDisease.setDisease_ID(id);
            return diseaseRepo.save(newDisease);
        });
    }

    public void deleteDisease(@PathVariable long id){ diseaseRepo.deleteById(id); }

}
