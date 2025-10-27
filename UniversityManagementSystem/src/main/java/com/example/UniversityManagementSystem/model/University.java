package com.example.UniversityManagementSystem.model;
import java.util.List;
import java.util.ArrayList;

public class University {
    private String id;
    private String name;
    private String city;
    private List<Department> departments;
    private List<Room> rooms;

    //Constructor
    public University(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.departments = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    //Getters and Setters
    public String getId() { return id;}
    public void setId(String id) { this.id = id;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public String getCity() { return city;}
    public void setCity(String city) { this.city = city;}
    public List<Department> getDepartments() { return departments;}


    public void addDepartment(Department t){this.departments.add(t);}
    public void addRoom(Room t){this.rooms.add(t);}

    @Override
    public String toString() {
        return "ID: "+ id+ "Name: "+ name+ "City: "+ city;
    }
}
