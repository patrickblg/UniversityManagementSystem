package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Course;
import org.springframework.stereotype.Repository;



@Repository
public class CourseRepository extends InFileRepo<Course> {

    public CourseRepository(){
        super("course.json",Course.class);
    }
}

