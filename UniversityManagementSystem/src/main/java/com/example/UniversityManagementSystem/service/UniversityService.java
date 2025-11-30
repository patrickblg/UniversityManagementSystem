package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.University;
import com.example.UniversityManagementSystem.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository= universityRepository;
    }

    public void saveUniversity(University u){
        universityRepository.save(u);
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

    public void updateUniversity(University u){
        universityRepository.update(u);
    }
}
