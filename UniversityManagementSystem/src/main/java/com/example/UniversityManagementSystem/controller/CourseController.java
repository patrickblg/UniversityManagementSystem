package com.example.UniversityManagementSystem.controller;


//+teachingAssignement

import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.service.CourseService;
import com.example.UniversityManagementSystem.service.TeacherService;
import com.example.UniversityManagementSystem.service.TeachingAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private final CourseService courseService;
    private final TeachingAssignmentService teachingAssignmentService;

    public CourseController(CourseService courseService, TeachingAssignmentService teachingAssignmentService) {
        this.courseService = courseService;
        this.teachingAssignmentService = teachingAssignmentService;
    }

    @GetMapping
    public String getALlCourseAndTeachingAssignements(Model model) {
        model.addAttribute("courses",courseService.findAllCourses());
        model.addAttribute("teachingAssignments",teachingAssignmentService.findAllTeachingAssignments());
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

    @GetMapping("/new-teachingassignment")
    public String showTeachingAssignmentForm(Model model) {
        model.addAttribute("teachingAssignment",new TeachingAssignment());
        return "course/teachingassignment-form";
    }

    @PostMapping("/add-teachingassignment")
    public String addTeachingAssignment(@ModelAttribute TeachingAssignment teachingAssignment) {
        teachingAssignmentService.saveTeachingAssignment(teachingAssignment);
        return "redirect:/course";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return "redirect:/course";

    }

    @PostMapping("/teachingassignment/{id}/delete")
    public String deleteTeachingAssignment(@PathVariable String id) {
        teachingAssignmentService.deleteteachingAssignment(id);
        return "redirect:/course";
    }

}
