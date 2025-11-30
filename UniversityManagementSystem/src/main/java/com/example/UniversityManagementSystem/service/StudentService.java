package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.EnrollmentRepository;
import com.example.UniversityManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;
    public StudentService(StudentRepository studentRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
    }
    public void saveStudent(Student s) {
        studentRepository.save(s);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    public Student findStudent(String id){
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudentById(String studentId){
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }
}
