package com.example.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="courses")
public class Course implements Identifiable {
    @Id
    private String id;
    private String title;
    private int credits;
    private double duration;

    @ManyToOne
    @JoinColumn(name="room_id")
    @JsonBackReference
    private Room room;

    @ManyToOne
    @JoinColumn(name="department_id")
    @JsonBackReference
    private Department department;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Enrollment> enrollments = new ArrayList<>();
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TeachingAssignment> assignments = new ArrayList<>();


    public Course(String id, String title, int credits, double duration) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.duration = duration;

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
    public void setEnrollments( List<Enrollment> enrollments ) {
       this.enrollments = enrollments;
    }
    public List<TeachingAssignment> getAssignments() {
        return assignments;
    }
    public void setAssignments(List<TeachingAssignment> assignments) {
        this.assignments = assignments ;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }



}
