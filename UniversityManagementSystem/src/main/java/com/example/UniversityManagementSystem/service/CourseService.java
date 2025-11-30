package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.repository.CourseRepository;
import com.example.UniversityManagementSystem.repository.EnrollmentRepository;
import com.example.UniversityManagementSystem.repository.TeachingAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final TeachingAssignmentRepository teachingAssignmentRepository;
    private final DepartmentService departmentService;

    public CourseService(CourseRepository courseRepository,EnrollmentRepository enrollmentRepository,TeachingAssignmentRepository teachingAssignmentRepository, DepartmentService departmentService) {
        this.courseRepository= courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.teachingAssignmentRepository = teachingAssignmentRepository;
        this.departmentService = departmentService;
    }
    public Course saveCourse(Course c ){

        return courseRepository.save(c);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    public Course findCourseById(String id){
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(String courseId){

        courseRepository.deleteById(courseId);
    }

    public void updateCourse(Course c){
        courseRepository.save(c);
    }
}





