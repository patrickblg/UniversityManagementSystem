package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository= courseRepository;
    }
    public Course saveCourse(Course c ){
        return courseRepository.save(c);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    public Course findCourseById(String id){
        return courseRepository.findById(id);
    }

    public void deleteCourse(String id){
        courseRepository.delete(id);
    }


}

