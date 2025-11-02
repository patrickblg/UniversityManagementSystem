package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Assistant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AssistantRepository implements BaseRepo<Assistant> {

    private final List<Assistant> assistants= new ArrayList<>();

    @Override
    public Assistant save(Assistant a) {
        assistants.add(a);
        return a;
    }
    @Override
    public List<Assistant> findAll() {
        List<Assistant> tempList = new ArrayList<>();
        for (Assistant a : assistants) {
            tempList.add(a);
        }
        return tempList;
    }
    @Override
    public Assistant findById(String id) {
        for (Assistant a : assistants) {
            if(a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
    @Override
    public void delete(String id){
        for(int i=0;i<assistants.size();i++){
            if(assistants.get(i).getId().equals(id)){
                assistants.remove(i);
                i--;
            }
        }
    }
}