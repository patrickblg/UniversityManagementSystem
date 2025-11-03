package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Assistant extends Staff{
    private String role;//LAB/TA/GRADER

    //Constructor
    public Assistant(String id, String name, String role){
        super(id,name);
        this.role=role;
        List<TeachingAssignment> teachingAssignments=new ArrayList<TeachingAssignment>();
    }
    //EmptyConstructor for Thymeleaf
    public Assistant(){

    }

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}


}
