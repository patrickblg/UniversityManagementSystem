package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final RoomRepository roomRepository;

    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository, RoomRepository roomRepository) {
        this.courseRepository= courseRepository;
        this.departmentRepository = departmentRepository;
        this.roomRepository = roomRepository;

    }
    public void saveCourse(Course c ){
        if (c.getDepartment() == null || c.getDepartment().getId() == null || !departmentRepository.existsById(c.getDepartment().getId())) {
            throw new IllegalArgumentException("Nu se poate salva cursul: Departamentul asociat nu există.");
        }

        if (c.getRoom() == null || c.getRoom().getId() == null || !roomRepository.existsById(c.getRoom().getId())) {
            throw new IllegalArgumentException("Nu se poate salva cursul: Sala asociată nu există.");
        }
        courseRepository.save(c);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }
    public List<Course> findAllCourses(String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }

        return  courseRepository.findAll(sort);
    }

    public Course findCourseById(String id){
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(String courseId){

        courseRepository.deleteById(courseId);
    }

    public void updateCourse(Course c){
        if (c.getDepartment() == null || c.getDepartment().getId() == null || !departmentRepository.existsById(c.getDepartment().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza cursul: Departamentul asociat nu există.");
        }
        if (c.getRoom() == null || c.getRoom().getId() == null || !roomRepository.existsById(c.getRoom().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza cursul: Sala asociată nu există.");
        }
        courseRepository.save(c);
    }
}





