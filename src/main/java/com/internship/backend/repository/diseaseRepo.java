package com.internship.backend.repository;

import com.internship.backend.model.disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface diseaseRepo extends JpaRepository<disease, Long> {
//    List<Disease> findDiseaseByUserId(long user_id);
//    List<Disease> findByUserId(long userId);
//    Disease findByUserId(long id);
}
