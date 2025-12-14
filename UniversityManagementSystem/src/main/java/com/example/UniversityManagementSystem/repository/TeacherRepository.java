package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.model.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {
    List<Teacher> findByNameContainingIgnoreCase(String name, Sort sort);
    List<Teacher> findByTitleContainingIgnoreCase(String title, Sort sort);
    List<Teacher> findByDepartment_NameContainingIgnoreCase(String departmentName, Sort sort);
    List<Teacher> findByDepartment_NameContainingIgnoreCaseAndTitleContainingIgnoreCase(String departmentName, String title, Sort sort);
}
