package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Teacher;
import com.example.UniversityManagementSystem.repository.DepartmentRepository;
import com.example.UniversityManagementSystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    public TeacherService(TeacherRepository teacherRepository, DepartmentRepository departmentRepository) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
    }
    public Teacher save(Teacher teacher){
        if (teacher.getDepartment() == null || teacher.getDepartment().getId() == null || !departmentRepository.existsById(teacher.getDepartment().getId())) {
            throw new IllegalArgumentException("Nu se poate salva profesorul: Departamentul asociat nu există.");
        }
        return teacherRepository.save(teacher);
    }
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
    public Teacher findById(String id){
        return teacherRepository.findById(id).orElse(null);
    }
    public void delete(String id){
        teacherRepository.deleteById(id);
    }
    public void updateTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
}
