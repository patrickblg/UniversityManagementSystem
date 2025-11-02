package com.example.UniversityManagementSystem.model;
import java.util.List;
import java.util.ArrayList;


public abstract class Staff {
    private String id;
    private String name;
    private List<TeachingAssignment>assignments;

    //Constructor
    public Staff(String id, String name){
        this.id = id;
        this.name = name;
        List<TeachingAssignment> assignments = new ArrayList<>();
    }

    public Staff(){

    }
    //Getters and Setter
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<TeachingAssignment> getAssignments() {return assignments;}


    public void addAssignment(TeachingAssignment assignment){assignments.add(assignment);}



}
