package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class TeacherRepository implements BaseRepo<Teacher> {
    private final List<Teacher> teachers = new ArrayList<>();

    @Override
    public Teacher save(Teacher t){
        teachers.add(t);
        return t;
    }
    @Override
    public Teacher findById(String id){
        for(Teacher t: teachers){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> findAll(){
        List<Teacher>tempList= new ArrayList<>();
        for(Teacher t: teachers){
            tempList.add(t);
        }
        return tempList;
    }
    @Override
    public void delete(String id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.remove(i);
                i--;
            }
        }
    }
}
