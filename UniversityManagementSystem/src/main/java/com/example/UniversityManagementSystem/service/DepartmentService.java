package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();

    }
    public Department findDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(String id){
        departmentRepository.delete(id);
    }
}
