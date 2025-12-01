package com.example.UniversityManagementSystem.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity

public class Student implements Identifiable{
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student(String studentId, String name) {
        this.id = studentId;
        this.name = name;

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
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }


}
