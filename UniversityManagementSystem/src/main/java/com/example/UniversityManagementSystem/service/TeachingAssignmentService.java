package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.repository.TeachingAssignmentRepository;


import java.util.List;
public class TeachingAssignmentService {
    private TeachingAssignmentRepository teachingAssignmentRepository;

    public TeachingAssignmentService(TeachingAssignmentRepository teachingAssignmentRepository) {
        this.teachingAssignmentRepository= teachingAssignmentRepository;
    }

    public TeachingAssignment saveTeachingAssignment(TeachingAssignment t){
        return teachingAssignmentRepository.save(t);
    }

    public List<TeachingAssignment> findAllTeachingAssignments(){
        return teachingAssignmentRepository.findAll();
    }

    public TeachingAssignment findTeachingAssignmentById(String id){
        return teachingAssignmentRepository.findById(id);
    }

    public void deleteteachingAssignment(String id){
        teachingAssignmentRepository.delete(id);
    }

}
