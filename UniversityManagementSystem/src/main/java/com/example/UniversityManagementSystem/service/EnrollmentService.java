package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    public void getEnrollmentCountsPerStudent(List<Student> students) {
        List<Enrollment> enrollments = getAllEnrollments();

        for (Student s : students) {
            int count = 0;
            for (Enrollment e : enrollments) {
                if (e.getStudentId().equals(s.getId())) {
                    count++;
                }
            }
            s.setEnrollmentCount(count);
        }
    }


}
