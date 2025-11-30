package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.repository.CourseRepository;
import com.example.UniversityManagementSystem.repository.EnrollmentRepository;
import com.example.UniversityManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;


    }
    @Transactional
    public Enrollment getEnrollmentById(String id) {
        return enrollmentRepository.findById(id).orElse(null);
    }
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    public void saveEnrollment(Enrollment e) {
        if (e.getStudent() == null || e.getStudent().getId() == null || !studentRepository.existsById(e.getStudent().getId())) {
            throw new IllegalArgumentException("Nu se poate crea înrolarea: Studentul cu ID-ul specificat nu există.");
        }
        if (e.getCourse() == null || e.getCourse().getId() == null || !courseRepository.existsById(e.getCourse().getId())) {
            throw new IllegalArgumentException("Nu se poate crea înrolarea: Cursul cu ID-ul specificat nu există.");
        }
         enrollmentRepository.save(e);
    }
    public void deleteEnrollmentById(String id) {
        enrollmentRepository.deleteById(id);
    }
    public void updateEnrollment(Enrollment enrollment) {
        // Business Logic: Verifică din nou existența la update (opțional, dar recomandat)
        if (enrollment.getStudent() == null || enrollment.getStudent().getId() == null || !studentRepository.existsById(enrollment.getStudent().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza înrolarea: Studentul cu ID-ul specificat nu există.");
        }
        if (enrollment.getCourse() == null || enrollment.getCourse().getId() == null || !courseRepository.existsById(enrollment.getCourse().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza înrolarea: Cursul cu ID-ul specificat nu există.");
        }
        enrollmentRepository.save(enrollment);
    }

}
