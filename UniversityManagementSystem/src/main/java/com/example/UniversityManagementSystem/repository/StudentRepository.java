package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.model.University;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    List<Student> findByNameContainingIgnoreCase(String name, Sort sort);

}
