package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Teacher;

import java.util.List;
import java.util.ArrayList;

public class TeacherRepository {
    private final List<Teacher> teachers = new ArrayList<>();

    public Teacher save(Teacher t){
        teachers.add(t);
        return t;
    }

    public Teacher findById(String id){
        for(Teacher t: teachers){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    public List<Teacher> findAll(){
        List<Teacher>tempList= new ArrayList<>();
        for(Teacher t: teachers){
            tempList.add(t);
        }
        return tempList;
    }

    public void delete(String id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.remove(i);
                i--;  // adjust index after removal
            }
        }
    }
}
