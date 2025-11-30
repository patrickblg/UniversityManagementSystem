package com.example.UniversityManagementSystem.controller;


import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.service.TeachingAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachingassignment")
public class TeachingAssignmentController {

    private final TeachingAssignmentService teachingAssignmentService;


    public TeachingAssignmentController(TeachingAssignmentService teachingAssignmentService) {
        this.teachingAssignmentService = teachingAssignmentService;
    }

    @GetMapping
    public String showAllTeachingAssignments(Model model) {
        model.addAttribute("teachingassignments",teachingAssignmentService.findAllTeachingAssignments());
        return "teachingassignment/index";
    }
    @GetMapping("/new-teachingassignment")
    public String showTeachingAssignmentForm(Model model) {
        model.addAttribute("teachingAssignment",new TeachingAssignment());
        return "teachingassignment/form";
    }
    @PostMapping("/add-teachingassignment")
    public String addTeachingAssignment(@ModelAttribute TeachingAssignment teachingAssignment) {
        teachingAssignmentService.saveTeachingAssignment(teachingAssignment);
        return "redirect:/teachingassignment";
    }
    @GetMapping("/{id}/edit-teachingassignment")
    public String showEditTeachingassignmentForm(@PathVariable String id, Model model) {
        TeachingAssignment teachingassignment = teachingAssignmentService.findTeachingAssignmentById(id);
        if (teachingassignment == null) return "redirect:/teachingassignment";

        model.addAttribute("teachingassignment", teachingassignment);
        return "teachingassignment/ta-edit-form";
    }
    @PostMapping("/{id}/update-teachingassignment")
    public String updateTeachingAssignment(@PathVariable String id, @ModelAttribute TeachingAssignment updatedTeachingAssignment) {

        updatedTeachingAssignment.setId(id);
        teachingAssignmentService.updateTeachingAssignment(updatedTeachingAssignment);
        return "redirect:/teachingassignment";
    }
    @PostMapping("/{id}/delete")
    public String deleteTeachingAssignment(@PathVariable String id) {
        teachingAssignmentService.deleteteachingAssignment(id);
        return "redirect:/teachingassignment";
    }
}
