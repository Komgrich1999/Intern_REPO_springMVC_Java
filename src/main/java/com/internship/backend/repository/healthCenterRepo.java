package com.internship.backend.repository;

import com.internship.backend.model.healthCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface healthCenterRepo extends JpaRepository<healthCenter, Long> {
}
