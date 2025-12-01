package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.service.CourseService;
import com.example.UniversityManagementSystem.service.DepartmentService;
import com.example.UniversityManagementSystem.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final DepartmentService departmentService;
    private final RoomService roomService;

    public CourseController(CourseService courseService, DepartmentService departmentService, RoomService roomService) {
        this.courseService = courseService;
        this.departmentService = departmentService;
        this.roomService = roomService;
    }

    @GetMapping
    public String getALlCourses(Model model) {
        model.addAttribute("courses",courseService.findAllCourses());
        return "course/index";
    }

    @GetMapping("/new")
    public String showCourseForm(Model model) {
        model.addAttribute("course",new Course());
        model.addAttribute("allDepartments", departmentService.findAllDepartments());
        model.addAttribute("allRooms", roomService.findAllRooms());
        return "course/course-form";
    }

    @PostMapping("/add-course")
    public String addCourse(@Valid @ModelAttribute Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            model.addAttribute("allRooms", roomService.findAllRooms());
            return "course/course-form";
        }
        try {
            courseService.saveCourse(course);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            model.addAttribute("allRooms", roomService.findAllRooms());
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
        model.addAttribute("allDepartments", departmentService.findAllDepartments());
        model.addAttribute("allRooms", roomService.findAllRooms());
        return "course/course-edit-form";
    }

    @PostMapping("/{id}/update-course")
    public String updateCourse(@PathVariable String id, @Valid @ModelAttribute Course updateCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            model.addAttribute("allRooms", roomService.findAllRooms());
            return "course/course-edit-form";
        }
        try {
            updateCourse.setId(id);
            courseService.updateCourse(updateCourse);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            model.addAttribute("allRooms", roomService.findAllRooms());
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