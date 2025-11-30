package com.example.UniversityManagementSystem.controller;


import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.service.EnrollmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/new-enrollment")
    public String showEnrollmentForm(Model model){
        model.addAttribute("enrollment", new Enrollment());
        return "enrollment/form";
    }
    @PostMapping("/add-enrollment")
    public String addEnrollment(@ModelAttribute Enrollment enrollment){
        enrollmentService.saveEnrollment(enrollment);
        return "redirect:/enrollment";
    }

    @GetMapping("/{id}/edit-enrollment")
    public String showEditEnrollmentForm(@PathVariable String id, Model model){
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if(enrollment == null){return "redirect:/enrollment";}
        model.addAttribute("enrollment",enrollment);
        return "enrollment/form";

    }
    @PostMapping("/{id}/update-enrollment")
    public String updateEnrollment(@PathVariable String id,@ModelAttribute Enrollment enrollment){
        enrollment.setId(id);
        enrollmentService.updateEnrollment(enrollment);
        return "redirect:/enrollment";
    }
    @PostMapping("/{id}/delete")
    public String deleteEnrollment(@PathVariable String id){
        enrollmentService.deleteEnrollmentById(id);
        return "redirect:/enrollment";

    }

}
