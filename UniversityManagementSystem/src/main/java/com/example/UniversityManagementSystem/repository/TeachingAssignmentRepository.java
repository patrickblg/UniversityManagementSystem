package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.TeachingAssignment;

import java.util.List;
import java.util.ArrayList;

public class TeachingAssignmentRepository implements BaseRepo<TeachingAssignment> {
    private final List<TeachingAssignment> teachingAssignments = new ArrayList<>();

    @Override
    public TeachingAssignment save(TeachingAssignment teachingAssignment) {
        teachingAssignments.add(teachingAssignment);
        return teachingAssignment;
    }
    @Override
    public TeachingAssignment findById(String id) {
        for (TeachingAssignment teachingAssignment : teachingAssignments) {
            if (teachingAssignment.getId().equals(id)) {
                return teachingAssignment;
            }
        }
        return null;
    }
    @Override
    public List<TeachingAssignment> findAll() {
        List<TeachingAssignment> teachingAssignmentsTemp = new ArrayList<>();
        for (TeachingAssignment teachingAssignment : teachingAssignments) {
            teachingAssignmentsTemp.add(teachingAssignment);
        }
        return teachingAssignmentsTemp;

    }
    @Override
    public void delete(String id){
        for(int i=0;i<teachingAssignments.size();i++){
            if(teachingAssignments.get(i).getId().equals(id)){
                teachingAssignments.remove(i);
                i--;
            }
        }
    }
}
