package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }
    public void saveStudent(Student s) {
        studentRepository.save(s);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudents(String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }

        return  studentRepository.findAll(sort);
    }
    @Transactional
    public Student findStudent(String id){
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudentById(String studentId){
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }
}
