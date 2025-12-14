package com.example.UniversityManagementSystem.converter;

import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.repository.CourseRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCourseConverter implements Converter<String, Course> {

    private final CourseRepository courseRepository;

    public StringToCourseConverter(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        return courseRepository.findById(source).orElse(null);
    }
}