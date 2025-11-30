package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Teacher extends Staff{

    private String title;
    private String departmentId;

    //Constructor
    public Teacher(String id, String name,String title){
        super(id,name);
        this.title=title;
        this.departmentId=departmentId;

    }

    //EmptyConstructor for Thymeleaf
    public Teacher(){

    }
    //Getters and Setters
    public String getTitle() {return title;}
    public void setTitle(String title) { this.title = title; }

    public String getDepartmentId() {return departmentId;}
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId;}

}
