package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.model.Teacher;
import com.example.UniversityManagementSystem.service.TeacherService;
import com.example.UniversityManagementSystem.service.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//teacher+assistant
@Controller
@RequestMapping("/staff")
public class StaffController {

    private final TeacherService teacherService;
    private final AssistantService assistantService;

    @Autowired
    public StaffController(TeacherService teacherService, AssistantService assistantService) {
        this.teacherService = teacherService;
        this.assistantService = assistantService;
    }

    @GetMapping
    public String getAllStaff(Model model){
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("assistants",assistantService.findAllAssistants());
        return "staff/index";
    }

    @GetMapping("/new-teacher")
    public String showAddTeacherForm(Model model){
        model.addAttribute("teacher",new Teacher());
        return "staff/teacher-form";
    }

    @PostMapping("/add-teacher")
    public String addTeacher(@ModelAttribute Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/staff";
    }

    @GetMapping("/new-assistant")
    public String showAssistantForm(Model model){
        model.addAttribute("assistant",new Assistant());
        return "staff/assistant-form";
    }

    @PostMapping("/add-assistant")
    public String addAssistant(@ModelAttribute Assistant assistant){
        assistantService.saveAssistant(assistant);
        return "redirect:/staff";
    }
    @PostMapping("/teacher/{id}/delete")
    public String deleteTeacher(@PathVariable String id){
        teacherService.delete(id);
        return "redirect:/staff";
    }

    @PostMapping("/assistant/{id}/delete")
    public String deleteAssistant(@PathVariable String id){
        assistantService.deleteAssistant(id);
        return "redirect:/staff";
    }



}
