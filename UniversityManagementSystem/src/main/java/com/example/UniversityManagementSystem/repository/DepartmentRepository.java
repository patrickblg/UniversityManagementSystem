package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements BaseRepo<Department>{
    private final List<Department> departments = new ArrayList<>();

    @Override
    public Department save(Department d) {
        departments.add(d);
        return d;
    }
    @Override
    public List<Department> findAll() {
        List<Department> tempList = new ArrayList<>();
        for (Department d : departments) {
            tempList.add(d);
        }
        return tempList;

    }
    @Override
    public Department findById(String id) {
        for (Department d : departments) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
    @Override
    public void delete(String id){
        for(int i = 0; i < departments.size(); i++){
            if(departments.get(i).getId().equals(id)){
                departments.remove(i);
                i--;
            }
        }
    }
}
