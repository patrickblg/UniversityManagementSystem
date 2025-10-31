package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Course;
import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.List;
import java.util.ArrayList;

public class CourseRepository implements BaseRepo<Course> {
    private final List<Course> courses = new ArrayList<>();

    @Override
    public Course save(Course c) {
        courses.add(c);
        return c;
    }
    @Override
    public List<Course> findAll() {
        return courses;
    }
    @Override
    public Course findById(String id) {
        for (Course c : courses) {
            if(c.getCourseId().equals(id)) {
                return c;
            }
        }
        return null;
    }
    @Override
    public void delete(String id) {
        for (int i = 0; i<courses.size(); i++) {
            if(courses.get(i).getCourseId().equals(id)) {
                courses.remove(i);
                i--;
            }
        }
    }
}
