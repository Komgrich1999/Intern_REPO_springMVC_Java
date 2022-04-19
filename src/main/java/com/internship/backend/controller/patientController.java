package com.internship.backend.controller;

//import com.internship.backend.exception.patientNotFoundException;
//import com.internship.backend.model.patient;
//import com.internship.backend.repository.patientRepo;

import com.internship.backend.model.patient;
import com.internship.backend.service.patientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
public class patientController {

    private patientService patientService;

    patientController(patientService patientService){
        this.patientService = patientService;
    }

    @GetMapping(path="/patient")
    public List<patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @GetMapping(path="/patient/{id}")
    public patient getOnePatient(@PathVariable long id){
        return patientService.getOnePatient(id);
    }

    @PostMapping(path="/patient")
    public patient addPatient(@RequestBody patient patient){
        return patientService.newPatient(patient);
    }

    @PutMapping(path="/patient/{id}")
    public patient replacePatient(@RequestBody patient newPatient,@PathVariable long id){
        return patientService.replacePatient(newPatient,id);
    }

    @DeleteMapping(path="/patient/{id}")
    public void deletePatient(@PathVariable long id){
        patientService.deletePatient(id);
    }


}
