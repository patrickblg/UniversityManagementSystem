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

        if(departmentService.findDepartmentById(c.getDepartmentId())==null){
            throw new IllegalArgumentException("Department not found");
        }
        return courseRepository.save(c);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    public Course findCourseById(String id){
        return courseRepository.findById(id);
    }

    public void deleteCourse(String courseId){

        courseRepository.delete(courseId);

        for(Enrollment e:enrollmentRepository.findAll()){
            if (e.getCourseId().equals(courseId)){
                enrollmentRepository.delete(e.getId());
            }
        }
        for(TeachingAssignment t:teachingAssignmentRepository.findAll()){
            if(t.getCourseId().equals(courseId)){
                teachingAssignmentRepository.delete(t.getId());
            }
        }
    }


    public void updateCourse(Course c){
        courseRepository.update(c);
    }
}





