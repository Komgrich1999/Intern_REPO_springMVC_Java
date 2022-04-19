package com.internship.backend.repository;

import com.internship.backend.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<user, Long> {
//    List<User> findUserByDiseaseId(long disease_id);
//    List<User> findByPassword(String password);
//    User findById(long id);
}
