package com.example.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

public class Teacher extends Staff{

    @NotBlank
    @Size(min = 3)
    private String title;

    @ManyToOne
    @JoinColumn(name="department_id")
    @JsonBackReference
    private Department department;


    //Constructor
    public Teacher(String id, String name,String title) {
        super(id,name);
        this.title=title;


    }

    //EmptyConstructor for Thymeleaf
    public Teacher(){

    }
    //Getters and Setters
    public String getTitle() {return title;}
    public void setTitle(String title) { this.title = title; }

    public Department getDepartment() {return department;}
    public void setDepartment(Department department) { this.department = department; }

}
