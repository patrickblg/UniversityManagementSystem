package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Student;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository extends InFileRepo<Student> {
   public StudentRepository() {
       super("UniversityManagementSystem/src/main/resources/data/student.json", Student.class);
   }


}
