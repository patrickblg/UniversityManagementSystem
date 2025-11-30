package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
public class Room  implements Identifiable{
    @Id
    private String id;
    private double capacity;
    private String number;
    private String name;

    @ManyToOne
    @JoinColumn(name="university_id")
    @JsonBackReference
    private University university;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Course> courses =  new ArrayList<>();


    public Room(String id, double capacity, String number, String name) {
        this.id = id;
        this.capacity = capacity;
        this.number = number;
        this.name = name;
    }
    public Room() {}
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id= id;
    }
    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
       this.courses = courses;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }

}
