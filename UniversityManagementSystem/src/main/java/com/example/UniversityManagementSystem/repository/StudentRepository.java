package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
@Repository
public class StudentRepository implements BaseRepo<Student> {
    private final List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student s) {
        students.add(s);
        return s;
    }
    @Override
    public Student findById(String id) {
        for (Student s : students) {
            if(s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }
    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)) {
                students.remove(i);
                i--;
            }
        }
    }
}
