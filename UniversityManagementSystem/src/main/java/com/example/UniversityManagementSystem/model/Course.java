package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Course implements Identifiable {
    private String id;
    private String title;
    private int credits;
    private double duration;
    private List<Enrollment> enrollments;
    private List<TeachingAssignment> assignments;


    public Course(String id, String title, int credits, double duration) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.duration = duration;
        this.enrollments = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }
    public Course() {

    }
    @Override
    public String getId() {
        return id;
    }


    @Override
    public void setId(String id) {
        this.id=id;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
