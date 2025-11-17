package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Teacher;
import com.example.UniversityManagementSystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
    public Teacher findById(String id){
        return teacherRepository.findById(id);
    }
    public void delete(String id){
        teacherRepository.delete(id);
    }
    public void updateTeacher(Teacher teacher){
        teacherRepository.update(teacher);
    }
}
