package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    public Student findStudent(String id){
        return studentRepository.findById(id);
    }

    public void deleteStudentById(String id){
        studentRepository.delete(id);
    }
}
