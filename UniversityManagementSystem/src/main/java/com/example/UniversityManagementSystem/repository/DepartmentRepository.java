package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository extends InFileRepo<Department>{
    public DepartmentRepository(){
        super("UniversityManagementSystem/src/main/resources/data/department.json",Department.class);
    }

}
