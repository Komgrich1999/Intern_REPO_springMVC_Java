package com.internship.backend.controller;

import com.internship.backend.exception.PatientNotFoundException;
import com.internship.backend.model.Patient;
import com.internship.backend.repository.Patient_Repo;

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
public class PatientController {

    private final Patient_Repo patient_repo;

    PatientController(Patient_Repo patient_repo){
        this.patient_repo = patient_repo;
    }

    @GetMapping(path="/patient")
    List<Patient> getAllPatient(){
        return patient_repo.findAll();
    }

    @GetMapping(path="/patient/{id}")
    Patient getOnePatient(@PathVariable long id){
        return patient_repo.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
    }

    @PostMapping(path="/patient")
    Patient newPatient(@RequestBody Patient newPatient){
        return patient_repo.save(newPatient);
    }

    @PutMapping(path="/patient/{id}")
    Patient replacePatient(@RequestBody Patient newPatient,@PathVariable long id){
        return patient_repo.findById(id).map(
                Patient -> {
                    Patient.setDescription(newPatient.getDescription());
                    Patient.setIsAdmit(newPatient.getIsAdmit());
                    return patient_repo.save(Patient);
                }
        ).orElseGet(() -> {
            newPatient.setPatient_HN(id);
            return patient_repo.save(newPatient);
        });
    }

    @DeleteMapping(path="/patient/{id}")
    void deletePatient(@PathVariable long id){ patient_repo.deleteById(id);}


}
