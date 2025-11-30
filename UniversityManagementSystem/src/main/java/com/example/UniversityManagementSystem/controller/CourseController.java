package com.example.UniversityManagementSystem.controller;




import com.example.UniversityManagementSystem.model.Course;

import com.example.UniversityManagementSystem.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {


    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;

    }

    @GetMapping
    public String getALlCourses(Model model) {
        model.addAttribute("courses",courseService.findAllCourses());

        return "course/index";
    }

    @GetMapping("/new-course")
    public String showCourseForm(Model model) {
        model.addAttribute("course",new Course());
        return "course/course-form";
    }

    @PostMapping("/add-course")
    public String addCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/course";
    }
    @GetMapping("/{id}/edit-course")
    public String showEditCourseForm(@PathVariable String id, Model model) {
        Course course = courseService.findCourseById(id);
        if (course == null) return "redirect:/course";

        model.addAttribute("course", course);
        return "course/course-edit-form";
    }

    @PostMapping("/{id}/update-course")
    public String updateCourse(@PathVariable String id, @ModelAttribute Course updateCourse) {

        updateCourse.setId(id);
        courseService.updateCourse(updateCourse);
        return "redirect:/course";
    }


    @PostMapping("/{id}/delete")
    public String deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return "redirect:/course";

    }

}
