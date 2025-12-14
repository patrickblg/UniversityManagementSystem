package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.model.Room;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {
    List<Department> findByNameContainingIgnoreCase(String name, Sort sort);
    List<Department> findByUniversity_NameContainingIgnoreCase(String universityName, Sort sort);
}
