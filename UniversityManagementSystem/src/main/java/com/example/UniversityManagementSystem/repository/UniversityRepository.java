package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.University;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityRepository extends InFileRepo<University> {
    public UniversityRepository() {
        super("UniversityManagementSystem/src/main/resources/data/university.json", University.class);
    }

}
