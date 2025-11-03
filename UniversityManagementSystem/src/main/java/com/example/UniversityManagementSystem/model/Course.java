package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String title;
    private int credits;
    private List<Enrollment> enrollments;
    private List<TeachingAssignment> assignments;


    public Course(String courseId, String title, int credits) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.enrollments = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }
    public Course() {

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    public void addEnrollments( Enrollment enrollment ) {
        enrollments.add(enrollment);
    }
    public List<TeachingAssignment> getAssignments() {
        return assignments;
    }

    public void addteachingAssignments(  TeachingAssignment assignment ) {
        assignments.add(assignment) ;
    }
}
