package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.model.University;
import com.example.UniversityManagementSystem.repository.UniversityRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
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
    public List<University> findAllUniversities(String name, String city,String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }

        if(name!=null&&!name.isEmpty()&&city!=null&&!city.isEmpty()){
            return universityRepository.findByNameContainingIgnoreCaseAndCityIsContainingIgnoreCase(name,city,sort);
        }else if(name!=null&&!name.isEmpty()){
            return universityRepository.findByNameContainingIgnoreCase(name,sort);
        }else if(city!=null&&!city.isEmpty()){
            return universityRepository.findByNameContainingIgnoreCase(city,sort);
        }else {
            return universityRepository.findAll(sort);
        }
    }


    @Transactional
    public University findUniversityById(String id){
        return universityRepository.findById(id).orElse(null);
    }

    public void deleteUniversity(String id){
        universityRepository.deleteById(id);
    }

    public void updateUniversity(University u){
        universityRepository.save(u);
    }
}
