package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.model.Teacher;
import com.example.UniversityManagementSystem.repository.DepartmentRepository;
import com.example.UniversityManagementSystem.repository.TeacherRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    public TeacherService(TeacherRepository teacherRepository, DepartmentRepository departmentRepository) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
    }
    public Teacher save(Teacher teacher){
        if (teacher.getDepartment() == null || teacher.getDepartment().getId() == null || !departmentRepository.existsById(teacher.getDepartment().getId())) {
            throw new IllegalArgumentException("Nu se poate salva profesorul: Departamentul asociat nu există.");
        }
        return teacherRepository.save(teacher);
    }
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
    public List<Teacher> findAll(String name, String title, String departmentName, String sortField, String sortDirection) {
        Sort sort;

        if ("asc".equals(sortDirection)) {
            sort = Sort.by(sortField).ascending();
        } else {
            sort = Sort.by(sortField).descending();
        }

        if (title!=null && !title.isEmpty() && departmentName!=null && !departmentName.isEmpty()){
            return teacherRepository.findByDepartment_NameContainingIgnoreCaseAndTitleContainingIgnoreCase(departmentName, title, sort);
        }else if(name!=null && !name.isEmpty()) {
            return teacherRepository.findByNameContainingIgnoreCase(name, sort);
        } else if (title!=null && !title.isEmpty()) {
            return teacherRepository.findByTitleContainingIgnoreCase(title, sort);
        } else if (departmentName!=null && !departmentName.isEmpty()) {
            return teacherRepository.findByDepartment_NameContainingIgnoreCase(departmentName, sort);
        } else {
            return teacherRepository.findAll(sort);
        }

    }
    public Teacher findById(String id){
        return teacherRepository.findById(id).orElse(null);
    }
    public void delete(String id){
        teacherRepository.deleteById(id);
    }
    public void updateTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
}
