package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.University;
import com.example.UniversityManagementSystem.repository.UniversityRepository;


import java.util.List;
public class UniversityService {
    private UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository= universityRepository;
    }

    public University saveUniversity(University u){
        return universityRepository.save(u);
    }

    public List<University> findAllUniversities(){
        return universityRepository.findAll();
    }

    public University findUniversityById(String id){
        return universityRepository.findById(id);
    }

    public void deleteUniversity(String id){
        universityRepository.delete(id);
    }
}
