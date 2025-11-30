package com.example.UniversityManagementSystem.controller;


import com.example.UniversityManagementSystem.model.Teacher;
import com.example.UniversityManagementSystem.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public String showAllTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teacher/index";
    }
    @GetMapping("/new-teacher")
    public String showAddTeacherForm(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teacher/form";
    }
    @PostMapping("/add-teacher")
    public String addTeacher(@ModelAttribute Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teacher";
    }
    @GetMapping("/{id}/edit-teacher")
    public String showEditTeacherForm(@PathVariable String id, Model model) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) return "redirect:/teacher";

        model.addAttribute("teacher", teacher);
        return "teacher/teacher-edit-form";
    }
    @PostMapping("/{id}/update-teacher")
    public String updateTeacher(@PathVariable String id, @ModelAttribute Teacher updatedTeacher) {

        updatedTeacher.setId(id);
        teacherService.updateTeacher(updatedTeacher);
        return "redirect:/teacher";
    }
    @PostMapping("/{id}/delete")
    public String deleteTeacher(@PathVariable String id){
        teacherService.delete(id);
        return "redirect:/teacher";
    }


}
