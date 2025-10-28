package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Course;

import java.util.List;
import java.util.ArrayList;

public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();
    public Course save(Course c) {
        courses.add(c);
        return c;
    }

    public List<Course> findAll() {
        List<Course> coursesTemp = new ArrayList<>();
        for (Course c : courses) {
            coursesTemp.add(c);
        }
        return coursesTemp;
    }

    public Course findById(int id) {
        for (Course c : courses) {
            if(c.getCourseId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void delete(String id) {
        for (int i = 0; i<courses.size(); i++) {
            if(courses.get(i).getCourseId().equals(id)) {
                courses.remove(i);
                i--;
            }
        }
    }
}
