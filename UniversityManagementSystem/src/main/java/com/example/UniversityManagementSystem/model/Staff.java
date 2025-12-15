package com.example.UniversityManagementSystem.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="dtype",discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, property = "@class")

public abstract class Staff implements Identifiable {
    @Id
    @NotBlank(message = "id is required")
    protected String id;
    @NotBlank(message = "name is required")
    @Size(min = 3)
    protected String name;
    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<TeachingAssignment>assignments = new ArrayList<>();

    //Constructor
    public Staff(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Staff(){

    }
    //Getters and Setter
    @Override
    public String getId() {return id;}
    @Override
    public void setId(String id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<TeachingAssignment> getAssignments() {return assignments;}
    public void setAssignments(List<TeachingAssignment> assignments) {this.assignments = assignments;}



}
