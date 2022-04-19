package com.internship.backend.service;

import com.internship.backend.exception.patientNotFoundException;
import com.internship.backend.model.patient;
import com.internship.backend.repository.patientRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class patientService {

    private final patientRepo patientRepo;

    patientService(patientRepo patientRepo){
        this.patientRepo = patientRepo;
    }

    public List<patient> getAllPatient(){
        return patientRepo.findAll();
    }

    public patient getOnePatient(long id){
        return patientRepo.findById(id).orElseThrow(() -> new patientNotFoundException(id));
    }

    public patient newPatient(patient newPatient){
        return patientRepo.save(newPatient);
    }

    public patient replacePatient(patient newPatient, @PathVariable long id){
        return patientRepo.findById(id).map(
                Patient -> {
                    Patient.setDescription(newPatient.getDescription());
                    Patient.setIsAdmit(newPatient.getIsAdmit());
                    return patientRepo.save(Patient);
                }
        ).orElseGet(() -> {
            newPatient.setPatient_HN(id);
            return patientRepo.save(newPatient);
        });
    }

    public void deletePatient(@PathVariable long id){ patientRepo.deleteById(id);}

}
