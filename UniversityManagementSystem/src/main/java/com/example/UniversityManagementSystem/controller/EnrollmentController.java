package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public String showAllEnrollments(Model model) {
        model.addAttribute("enrollments",enrollmentService.getAllEnrollments());
        return "enrollment/index";
    }

    @GetMapping("/new")
    public String showEnrollmentForm(Model model){
        model.addAttribute("enrollment", new Enrollment());
        // Aici adaugi listele necesare pentru formulare (Student, Course)
        return "enrollment/form";
    }

    @PostMapping("/add-enrollment")
    public String addEnrollment(@Valid @ModelAttribute Enrollment enrollment, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "enrollment/form";
        }

        try {
            enrollmentService.saveEnrollment(enrollment);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/enrollment/new";
        }
        return "redirect:/enrollment";
    }

    @GetMapping("/{id}/details")
    public String showEnrollmentDetails(@PathVariable String id, Model model) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment == null) return "redirect:/enrollment";
        model.addAttribute("enrollment", enrollment);
        return "enrollment/details";
    }

    @GetMapping("/{id}/edit-enrollment")
    public String showEditEnrollmentForm(@PathVariable String id, Model model) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment == null) return "redirect:/enrollment";
        model.addAttribute("enrollment", enrollment);
        // Aici adaugi listele necesare pentru formulare
        return "enrollment/enrollment-edit-form";
    }

    @PostMapping("/{id}/update-enrollment")
    public String updateEnrollment(@PathVariable String id, @Valid @ModelAttribute Enrollment updatedEnrollment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "enrollment/enrollment-edit-form";
        }
        try {
            updatedEnrollment.setId(id);
            enrollmentService.updateEnrollment(updatedEnrollment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "enrollment/enrollment-edit-form";
        }
        return "redirect:/enrollment";
    }

    @PostMapping("/{id}/delete")
    public String deleteEnrollment(@PathVariable String id){
        enrollmentService.deleteEnrollmentById(id);
        return "redirect:/enrollment";
    }
}