package com.example.UniversityManagementSystem.model;


import java.util.ArrayList;
import java.util.List;

public class Student implements Identifiable{
    private String id;
    private String name;
    private List<Enrollment> enrollments;
    private int enrollmentCount;

    public Student(String studentId, String name) {
        this.id = studentId;
        this.name = name;
        this.enrollments = new ArrayList<>();
        this.enrollmentCount = 0;
    }
    public Student(){

    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String studentId) {
        this.id = studentId;
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
