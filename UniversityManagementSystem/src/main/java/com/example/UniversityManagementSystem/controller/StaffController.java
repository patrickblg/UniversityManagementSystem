package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.model.Student;
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
    @GetMapping("/teacher/{id}/edit-teacher")
    public String showEditTeacherForm(@PathVariable String id, Model model) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) return "redirect:/staff";

        model.addAttribute("teacher", teacher);
        return "staff/teacher-edit-form";
    }

    @PostMapping("/teacher/{id}/update-teacher")
    public String updateTeacher(@PathVariable String id, @ModelAttribute Teacher updatedTeacher) {

        updatedTeacher.setId(id);
        teacherService.updateTeacher(updatedTeacher);
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
    @GetMapping("/assistant/{id}/edit-assistant")
    public String showEditAssistantForm(@PathVariable String id, Model model) {
        Assistant assistant = assistantService.findAssistantById(id);
        if (assistant == null) return "redirect:/staff";

        model.addAttribute("assistant", assistant);
        return "staff/assistant-edit-form";
    }

    @PostMapping("/assistant/{id}/update-assistant")
    public String updateAssistant(@PathVariable String id, @ModelAttribute Assistant updatedAssistant) {

        updatedAssistant.setId(id);
        assistantService.updateAssistant(updatedAssistant);
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
