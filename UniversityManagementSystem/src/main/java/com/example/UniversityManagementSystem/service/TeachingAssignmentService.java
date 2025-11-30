package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.repository.TeachingAssignmentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TeachingAssignmentService {
    private final TeachingAssignmentRepository teachingAssignmentRepository;


    public TeachingAssignmentService(TeachingAssignmentRepository teachingAssignmentRepository) {
        this.teachingAssignmentRepository= teachingAssignmentRepository;
    }

    public void saveTeachingAssignment(TeachingAssignment t){


        teachingAssignmentRepository.save(t);
    }

    public List<TeachingAssignment> findAllTeachingAssignments(){
        return teachingAssignmentRepository.findAll();
    }

    public TeachingAssignment findTeachingAssignmentById(String id){
        return teachingAssignmentRepository.findById(id).orElse(null);
    }

    public void deleteteachingAssignment(String id){
        teachingAssignmentRepository.deleteById(id);
    }

    public void updateTeachingAssignment(TeachingAssignment t){
        teachingAssignmentRepository.save(t);
    }

}
