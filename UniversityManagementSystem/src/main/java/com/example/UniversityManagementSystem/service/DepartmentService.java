package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.model.Teacher;
import com.example.UniversityManagementSystem.repository.CourseRepository;
import com.example.UniversityManagementSystem.repository.DepartmentRepository;
import com.example.UniversityManagementSystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public DepartmentService(DepartmentRepository departmentRepository, CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.departmentRepository = departmentRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();

    }
    public Department findDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(String departmentId){

        departmentRepository.delete(departmentId);

        for(Course course : courseRepository.findAll()){
            if(course.getId().equals(departmentId)){
                courseRepository.delete(course.getId());
            }
        }
        for(Teacher teacher : teacherRepository.findAll()){
            if(teacher.getId().equals(departmentId)){
                teacherRepository.delete(teacher.getId());
            }
        }
    }


}
