package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.DepartmentRepository;
import com.example.UniversityManagementSystem.repository.UniversityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final UniversityRepository universityRepository;

    public DepartmentService(DepartmentRepository departmentRepository, UniversityRepository universityRepository) {
        this.departmentRepository = departmentRepository;
        this.universityRepository = universityRepository;
    }

    public Department save(Department department) {
        if (department.getUniversity() == null || department.getUniversity().getId() == null || !universityRepository.existsById(department.getUniversity().getId())) {
            throw new IllegalArgumentException("Nu se poate salva departamentul: Universitatea asociată nu există.");
        }
        return departmentRepository.save(department);
    }
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();

    }
    public List<Department> findAllDepartments(String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }

        return  departmentRepository.findAll(sort);
    }
    public Department findDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void deleteDepartment(String departmentId){

        departmentRepository.deleteById(departmentId);

    }

    public void updateDepartment(Department department){
        if (department.getUniversity() == null || department.getUniversity().getId() == null || !universityRepository.existsById(department.getUniversity().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza departamentul: Universitatea asociată nu există.");
        }
        departmentRepository.save(department);
    }


}
