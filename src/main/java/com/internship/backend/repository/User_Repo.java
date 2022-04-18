package com.internship.backend.repository;

import com.internship.backend.model.Disease;
import com.internship.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_Repo extends JpaRepository<User, Long> {
//    List<User> findUserByDiseaseId(long disease_id);
//    List<User> findByPassword(String password);
//    User findById(long id);
}
