package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity

public class Room  implements Identifiable{
    @Id
    @NotBlank(message = "id must not be null")
    private String id;
    @NotNull(message = "capacity must not be null")
    private double capacity;
    @NotBlank(message = "number must not be null")
    @Size(min = 1, max = 100)
    private String number;
    @NotBlank(message = "name must not be null")
    @Size(min = 3)
    private String name;

    @ManyToOne
    @JoinColumn(name="university_id")
    @JsonBackReference
    @NotNull(message = "university must not be null")
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
