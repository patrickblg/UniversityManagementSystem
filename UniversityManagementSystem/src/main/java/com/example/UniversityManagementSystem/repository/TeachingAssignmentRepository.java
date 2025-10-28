package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.TeachingAssignment;

import java.util.List;
import java.util.ArrayList;

public class TeachingAssignmentRepository {
    private final List<TeachingAssignment> teachingAssignments = new ArrayList<>();

    public TeachingAssignment save(TeachingAssignment teachingAssignment) {
        teachingAssignments.add(teachingAssignment);
        return teachingAssignment;
    }
    public TeachingAssignment findById(String id) {
        for (TeachingAssignment teachingAssignment : teachingAssignments) {
            if (teachingAssignment.getId().equals(id)) {
                return teachingAssignment;
            }
        }
        return null;
    }
    public List<TeachingAssignment> findAll() {
        List<TeachingAssignment> teachingAssignmentsTemp = new ArrayList<>();
        for (TeachingAssignment teachingAssignment : teachingAssignments) {
            teachingAssignmentsTemp.add(teachingAssignment);
        }
        return teachingAssignmentsTemp;

    }
}
