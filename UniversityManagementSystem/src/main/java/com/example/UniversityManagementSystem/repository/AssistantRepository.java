package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Assistant;

import java.util.ArrayList;
import java.util.List;

public class AssistantRepository {

    private final List<Assistant> assistants= new ArrayList<>();

    public Assistant save(Assistant a) {
        assistants.add(a);
        return a;
    }

    public List<Assistant> findAll() {
        List<Assistant> tempList = new ArrayList<>();
        for (Assistant a : assistants) {
            tempList.add(a);
        }
        return tempList;
    }
    public Assistant findById(String id) {
        for (Assistant a : assistants) {
            if(a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public void delete(String id){
        for(int i=0;i<assistants.size();i++){
            if(assistants.get(i).getId().equals(id)){
                assistants.remove(i);
                i--;
            }
        }
    }
}