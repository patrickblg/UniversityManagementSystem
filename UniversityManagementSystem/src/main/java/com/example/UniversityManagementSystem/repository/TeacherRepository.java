package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Teacher;
import org.springframework.stereotype.Repository;


@Repository
public class TeacherRepository extends InFileRepo<Teacher> {
    public TeacherRepository() {
        super("UniversityManagementSystem/src/main/resources/data/teacher.json", Teacher.class);
    }



}
