package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Teacher;
import com.example.UniversityManagementSystem.service.DepartmentService;
import com.example.UniversityManagementSystem.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final DepartmentService departmentService;

    public TeacherController(TeacherService teacherService, DepartmentService departmentService) {
        this.teacherService = teacherService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public String showAllTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teacher/index";
    }

    @GetMapping("/new")
    public String showAddTeacherForm(Model model){
        model.addAttribute("teacher",new Teacher());
        model.addAttribute("allDepartments", departmentService.findAllDepartments());
        return "teacher/form";
    }

    @PostMapping("/add-teacher")
    public String addTeacher(@Valid @ModelAttribute Teacher teacher, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            return "teacher/form";
        }
        try {
            teacherService.save(teacher);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            return "teacher/form";
        }
        return "redirect:/teacher";
    }

    @GetMapping("/{id}/details")
    public String showTeacherDetails(@PathVariable String id, Model model) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) return "redirect:/teacher";
        model.addAttribute("teacher", teacher);

        return "teacher/details";
    }

    @GetMapping("/{id}/edit-teacher")
    public String showEditTeacherForm(@PathVariable String id, Model model) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) return "redirect:/teacher";

        model.addAttribute("teacher", teacher);
        model.addAttribute("allDepartments", departmentService.findAllDepartments());
        // Aici adaugi listele necesare pentru formulare (Department)
        return "teacher/teacher-edit-form";
    }

    @PostMapping("/{id}/update-teacher")
    public String updateTeacher(@PathVariable String id, @Valid @ModelAttribute Teacher updatedTeacher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            return "teacher/teacher-edit-form";
        }
        try {
            updatedTeacher.setId(id);
            teacherService.updateTeacher(updatedTeacher);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("allDepartments", departmentService.findAllDepartments());
            return "teacher/teacher-edit-form";
        }
        return "redirect:/teacher";
    }

    @PostMapping("/{id}/delete")
    public String deleteTeacher(@PathVariable String id){
        teacherService.delete(id);
        return "redirect:/teacher";
    }
}