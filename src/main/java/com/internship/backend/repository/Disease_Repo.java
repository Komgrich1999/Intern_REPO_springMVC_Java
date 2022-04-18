package com.internship.backend.repository;

import com.internship.backend.model.Disease;
import com.internship.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Disease_Repo extends JpaRepository<Disease, Long> {
//    List<Disease> findDiseaseByUserId(long user_id);
//    List<Disease> findByUserId(long userId);
//    Disease findByUserId(long id);
}
