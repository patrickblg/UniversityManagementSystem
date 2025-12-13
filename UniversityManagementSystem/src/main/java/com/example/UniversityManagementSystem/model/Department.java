package com.example.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
@Entity

public class Department implements Identifiable {
    @Id
    @NotBlank(message = "id is required")//validare
    private String id;
    @NotBlank(message = "name is required")
    @Size(min = 3)
    private String name;

    @NotNull(message = "university must not be null")//validare
    @ManyToOne
    @JoinColumn(name="university_id")
    @JsonBackReference
    private University university;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Course> courses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="department_id")
    @JsonManagedReference
    private List<Teacher> teachers = new ArrayList<>();

    //Constructor
    public Department(String id, String name, University university) {
        this.id = id;
        this.name = name;
        this.university = university;
    }

    public Department() {

    }

    //Getters and Setters
    @Override
    public String getId() {return id;}
    @Override
    public void setId(String id) {this.id = id;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public List<Course> getCourses() {return courses;}
    public void setCourses(List<Course> courses) {this.courses = courses;}
    public List<Teacher> getTeachers() {return teachers;}
    public void setTeachers(List<Teacher> teachers) {this.teachers = teachers;}
    public University getUniversity() {return university;}
    public void setUniversity(University university) {this.university = university;}

}
