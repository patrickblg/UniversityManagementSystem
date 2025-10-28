package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.University;

import java.util.ArrayList;
import java.util.List;

public class UniveristyRepository {
    private final List<University>  universities= new ArrayList<>();

    public University save(University u){
        universities.add(u);
        return u;
    }

    public List<University> findAll(){
        List<University> tempList= new ArrayList<>();
        for(University u:universities){
            tempList.add(u);
        }
        return tempList;
    }
    public University findById(String id){
        for(University u:universities){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }

    public void delete(String id){
        for(int i=0;i<universities.size();i++){
            if(universities.get(i).getId().equals(id)){
                universities.remove(i);
                i--;
            }
        }
    }

}
