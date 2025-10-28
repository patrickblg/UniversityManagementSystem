package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Student;

import java.util.List;
import java.util.ArrayList;

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    public Student save(Student s) {
        students.add(s);
        return s;
    }
    public Student findById(String id) {
        for (Student s : students) {
            if(s.getStudentId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> findAll() {
        List<Student>studentsTemp = new ArrayList<>();
        for (Student s : students) {
            studentsTemp.add(s);
        }
        return studentsTemp;
    }

    public void delete(String id) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getStudentId().equals(id)) {
                students.remove(i);
                i--;
            }
        }
    }
}
