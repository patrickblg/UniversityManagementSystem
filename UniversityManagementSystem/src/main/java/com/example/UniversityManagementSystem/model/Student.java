package com.example.UniversityManagementSystem.model;


import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private List<Enrollment> enrollments;
    private int enrollmentCount;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrollments = new ArrayList<>();
        this.enrollmentCount = 0;
    }
    public Student(){

    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    public void addEnrollment(Enrollment enrollment) {
        this.enrollments.add(enrollment);
    }
    public int getEnrollmentCount() {
        return enrollmentCount;
    }
    public void setEnrollmentCount(int enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

}
