package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.repository.EnrollmentRepository;

import java.util.List;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
    public Enrollment getEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    public Enrollment saveEnrollment(Enrollment e) {
        return enrollmentRepository.save(e);
    }

    public void deleteEnrollmentById(String id) {
        enrollmentRepository.delete(id);
    }
}
