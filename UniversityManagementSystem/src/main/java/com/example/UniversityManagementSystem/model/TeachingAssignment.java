package com.example.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "teaching_assignments")
public class TeachingAssignment implements Identifiable{
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="course_id")
    @JsonBackReference
    private Course course;

    @ManyToOne
    @JoinColumn(name="staff_id")
    @JsonBackReference
    private Staff staff;

    private ManagingRole managing;

    public TeachingAssignment(String id, Course course, Staff staff, ManagingRole managing) {
        this.id = id;
        this.managing = managing;
        this.course = course;
        this.staff = staff;
    }
    public TeachingAssignment() {}
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    public ManagingRole getManaging() {
        return managing;
    }
    public void setManaging(ManagingRole managing) {
        this.managing = managing;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }


}
