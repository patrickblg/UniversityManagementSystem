package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Student;

import java.util.List;
import java.util.ArrayList;

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
            if(s.getStudentId().equals(id)) {
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
            if(students.get(i).getStudentId().equals(id)) {
                students.remove(i);
                i--;
            }
        }
    }
}
