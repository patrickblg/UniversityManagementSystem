package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Staff;

import java.util.ArrayList;
import java.util.List;


public class StaffRepository implements BaseRepo<Staff> {

    private final List<Staff> staff= new ArrayList<>();

    @Override
    public Staff save(Staff s){
        staff.add(s);
        return s;
    }
    @Override
    public List<Staff> findAll(){
        List<Staff>templist= new ArrayList<>();
        for(Staff s:staff){
            templist.add(s);
        }
        return templist;
    }

    @Override
    public Staff findById(String id){
        for(Staff s:staff){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }
    @Override
    public void delete(String id){
        for(int i=0;i<staff.size();i++){
            if(staff.get(i).getId().equals(id)){
                staff.remove(i);
                i--;
            }
        }
    }

}
