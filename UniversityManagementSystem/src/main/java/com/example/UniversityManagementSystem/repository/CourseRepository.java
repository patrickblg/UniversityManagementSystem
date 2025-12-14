package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Course;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    List<Course> findByTitleContainingIgnoreCase(String name, Sort sort);
    List<Course> findByCreditsLessThanEqual(Integer credits, Sort sort);
    List<Course>findByTitleContainingIgnoreCaseAndCreditsLessThanEqual(String name, Integer credits, Sort sort);

    //Departament
    List<Course> findByDepartment_NameContainingIgnoreCase(String departmentName, Sort sort);

    //Room
    List<Course> findByRoom_NameContainingIgnoreCase(String roomName, Sort sort);


    //  Combinație: Departament ȘI Credite
    List<Course> findByDepartment_NameContainingIgnoreCaseAndCreditsLessThanEqual(String departmentName, double credits, Sort sort);

    // Combinație: Titlu Curs ȘI Nume Departament
    List<Course> findByTitleContainingIgnoreCaseAndDepartment_NameContainingIgnoreCase(String title, String departmentName, Sort sort);

    // Combinație: Titlu Curs ȘI Nume Sala
    List<Course> findByTitleContainingIgnoreCaseAndRoom_NameContainingIgnoreCase(String title, String roomName, Sort sort);


    // Combinație: Toate cele 3 filtre
    List<Course> findByTitleContainingIgnoreCaseAndDepartment_NameContainingIgnoreCaseAndCreditsGreaterThanEqual(String title, String departmentName, double credits, Sort sort);
}

