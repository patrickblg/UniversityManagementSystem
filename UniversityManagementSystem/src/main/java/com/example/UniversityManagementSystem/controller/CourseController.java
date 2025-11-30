package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new")
    public String showCourseForm(Model model) {
        model.addAttribute("course",new Course());
        // Aici Controllerul ar trebui să adauge Department și Room disponibile
        return "course/course-form";
    }

    @PostMapping("/add-course")
    public String addCourse(@Valid @ModelAttribute Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "course/course-form";
        }
        try {
            courseService.saveCourse(course);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "course/course-form";
        }
        return "redirect:/course";
    }

    @GetMapping("/{id}/details")
    public String showCourseDetails(@PathVariable String id, Model model) {
        Course course = courseService.findCourseById(id);
        if (course == null) return "redirect:/course";
        model.addAttribute("course", course);
        return "course/details";
    }

    @GetMapping("/{id}/edit-course")
    public String showEditCourseForm(@PathVariable String id, Model model) {
        Course course = courseService.findCourseById(id);
        if (course == null) return "redirect:/course";

        model.addAttribute("course", course);
        // Aici Controllerul ar trebui să adauge Department și Room disponibile
        return "course/course-edit-form";
    }

    @PostMapping("/{id}/update-course")
    public String updateCourse(@PathVariable String id, @Valid @ModelAttribute Course updateCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "course/course-edit-form";
        }
        try {
            updateCourse.setId(id);
            courseService.updateCourse(updateCourse);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "course/course-edit-form";
        }
        return "redirect:/course";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return "redirect:/course";
    }
}