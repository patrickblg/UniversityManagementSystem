package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.service.TeachingAssignmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/new")
    public String showTeachingAssignmentForm(Model model) {
        model.addAttribute("teachingAssignment",new TeachingAssignment());
        // Aici adaugi listele necesare pentru formulare (Course, Staff/Teacher/Assistant)
        return "teachingassignment/form";
    }

    @PostMapping("/add-teachingassignment")
    public String addTeachingAssignment(@Valid @ModelAttribute TeachingAssignment teachingAssignment, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "teachingassignment/form";
        }
        try {
            teachingAssignmentService.saveTeachingAssignment(teachingAssignment);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/teachingassignment/new";
        }
        return "redirect:/teachingassignment";
    }

    @GetMapping("/{id}/details")
    public String showTeachingAssignmentDetails(@PathVariable String id, Model model) {
        TeachingAssignment ta = teachingAssignmentService.findTeachingAssignmentById(id);
        if (ta == null) return "redirect:/teachingassignment";
        model.addAttribute("teachingassignment", ta);
        return "teachingassignment/details";
    }

    @GetMapping("/{id}/edit-teachingassignment")
    public String showEditTeachingassignmentForm(@PathVariable String id, Model model) {
        TeachingAssignment teachingassignment = teachingAssignmentService.findTeachingAssignmentById(id);
        if (teachingassignment == null) return "redirect:/teachingassignment";

        model.addAttribute("teachingassignment", teachingassignment);
        // Aici adaugi listele necesare pentru formulare
        return "teachingassignment/ta-edit-form";
    }

    @PostMapping("/{id}/update-teachingassignment")
    public String updateTeachingAssignment(@PathVariable String id, @Valid @ModelAttribute TeachingAssignment updatedTeachingAssignment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "teachingassignment/ta-edit-form";
        }
        try {
            updatedTeachingAssignment.setId(id);
            teachingAssignmentService.updateTeachingAssignment(updatedTeachingAssignment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "teachingassignment/ta-edit-form";
        }
        return "redirect:/teachingassignment";
    }

    @PostMapping("/{id}/delete")
    public String deleteTeachingAssignment(@PathVariable String id) {
        teachingAssignmentService.deleteteachingAssignment(id);
        return "redirect:/teachingassignment";
    }
}