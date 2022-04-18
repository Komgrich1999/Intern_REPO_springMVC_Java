package com.internship.backend.repository;

import com.internship.backend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patient_Repo extends JpaRepository<Patient, Long> {

}
