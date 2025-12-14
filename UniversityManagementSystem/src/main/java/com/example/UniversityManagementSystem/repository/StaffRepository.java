package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, String> {
}
