package com.internship.backend.repository;

import com.internship.backend.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepo extends JpaRepository<patient, Long> {

}
