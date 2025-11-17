package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void saveStudent(Student s) {
        studentRepository.save(s);
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

    public void updateStudent(Student student){
        studentRepository.update(student);
    }
}
