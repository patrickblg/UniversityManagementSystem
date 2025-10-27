package com.example.UniversityManagementSystem.model;

public class Assistant extends Staff{
    private String role;//LAB/TA/GRADER

    //Constructor
    public Assistant(String id, String name, String role){
        super(id,name);
        this.role=role;
    }

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}


}
