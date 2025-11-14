package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Department implements Identifiable {
    private String id;
    private String name;
    private List<Course> courses;
    private List<Teacher> teachers;

    //Constructor
    public Department(String id, String name) {
        this.id = id;
        this.name = name;
        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
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
    public List<Teacher> getTeachers() {return teachers;}


    public void addCourse(Course t){this.courses.add(t);}
    public void addTeacher(Teacher t){this.teachers.add(t);}

}
