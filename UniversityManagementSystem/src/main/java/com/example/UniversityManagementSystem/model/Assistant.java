package com.example.UniversityManagementSystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity

public class Assistant extends Staff {

    @Enumerated(EnumType.STRING)
    @NotNull
    private AssistantRole role;//LAB/TA/GRADER

    //Constructor
    public Assistant(String id, String name, AssistantRole role){
        super(id,name);
        this.role=role;
    }
    //EmptyConstructor for Thymeleaf
    public Assistant(){

    }

    public AssistantRole getRole() {return role;}
    public void setRole(AssistantRole role) {this.role = role;}


}
