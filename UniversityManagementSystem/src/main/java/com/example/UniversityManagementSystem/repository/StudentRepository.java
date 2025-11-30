package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,String> {


}
