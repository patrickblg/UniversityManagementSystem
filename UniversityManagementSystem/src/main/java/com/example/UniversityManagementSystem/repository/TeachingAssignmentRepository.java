package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.TeachingAssignment;
import org.springframework.stereotype.Repository;


@Repository
public class TeachingAssignmentRepository extends InFileRepo<TeachingAssignment> {
    public TeachingAssignmentRepository() {
        super("UniversityManagementSystem/src/main/resources/data/teachingassignment.json", TeachingAssignment.class);
    }
}
