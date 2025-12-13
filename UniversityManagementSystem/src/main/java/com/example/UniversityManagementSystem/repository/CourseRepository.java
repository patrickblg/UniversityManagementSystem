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

}

