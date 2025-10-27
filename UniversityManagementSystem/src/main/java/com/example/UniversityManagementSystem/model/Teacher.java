package com.example.UniversityManagementSystem.model;

public class Teacher extends Staff{

    private String title;
    private String departmentId;

    //Constructor
    public Teacher(String id, String name,String title, String departmentId){
        super(id,name);
        this.title=title;
        this.departmentId=departmentId;
    }
    //Getters and Setters
    public String getTitle() {return title;}
    public void setTitle(String title) { this.title = title; }

    public String getDepartmentId() {return departmentId;}
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId;}

}
