package com.example.UniversityManagementSystem.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name="universities")
public class University implements Identifiable{
    @Id
    private String id;
    private String name;
    private String city;
    @OneToMany(mappedBy = "university",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Department> departments = new ArrayList<>();
    @OneToMany(mappedBy = "university",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Room> rooms = new ArrayList<>();

    //Constructor
    public University(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;

    }
    //Empty constructor for Thymeleaf
    public University(){

    }

    //Getters and Setters
    @Override
    public String getId() { return id;}
    @Override
    public void setId(String id) { this.id = id;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public String getCity() { return city;}
    public void setCity(String city) { this.city = city;}
    public List<Department> getDepartments() { return departments;}


    public void setDepartments(List<Department> departments) { this.departments = departments;}
    public List<Room> getRooms() {
        return rooms;
    }
    public void setRooms(List<Room> rooms) { this.rooms = rooms;}

}
