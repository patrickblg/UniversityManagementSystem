package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.EnrollmentRepository;
import com.example.UniversityManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;
    private final StudentRepository studentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentService studentService, CourseService courseService, StudentRepository studentRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService= courseService;
        this.studentRepository = studentRepository;
    }
    public Enrollment getEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    public Enrollment saveEnrollment(Enrollment e) {

        if(studentService.findStudent(e.getStudentId())==null){
            throw new IllegalArgumentException("Cannot create enrollment, student does not exist");
        }
        if(courseService.findCourseById(e.getCourseId())==null){
            throw new IllegalArgumentException("Cannot create enrollment, course does not exist");
        }
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

    public void updateEnrollment(Enrollment enrollment) {
        enrollmentRepository.update(enrollment);
    }


}
