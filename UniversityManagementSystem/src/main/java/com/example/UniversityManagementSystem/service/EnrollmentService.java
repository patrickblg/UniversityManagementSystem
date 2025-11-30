package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    public EnrollmentService(EnrollmentRepository enrollmentRepository,StudentService studentService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
    }
    public Enrollment getEnrollmentById(String id) {
        return enrollmentRepository.findById(id).orElse(null);
    }
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    public Enrollment saveEnrollment(Enrollment e) {

        return enrollmentRepository.save(e);
    }
    public void deleteEnrollmentById(String id) {
        enrollmentRepository.deleteById(id);
    }


}
