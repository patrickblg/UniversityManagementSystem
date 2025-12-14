package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.service.CourseService;
import com.example.UniversityManagementSystem.service.EnrollmentService;
import com.example.UniversityManagementSystem.service.StudentService;
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
    private final StudentService studentService;
    private final CourseService courseService;
    public EnrollmentController(EnrollmentService enrollmentService, StudentService studentService, CourseService courseService) {
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String showAllEnrollments(Model model,
                                     @RequestParam(value = "studentName", required = false) String studentName,
                                     @RequestParam(value = "courseTitle", required = false) String courseTitle,
                                     @RequestParam(value = "sortField",defaultValue = "id")String sortField,
                                     @RequestParam(value = "sortDir",defaultValue = "asc")String sortDir) {
        model.addAttribute("enrollments",enrollmentService.getAllEnrollments(studentName,courseTitle,sortField, sortDir));

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("studentName", studentName);
        model.addAttribute("courseTitle", courseTitle);
        return "enrollment/index";
    }

    @GetMapping("/new")
    public String showEnrollmentForm(Model model){
        model.addAttribute("enrollment", new Enrollment());
        model.addAttribute("allStudents", studentService.findAllStudents());
        model.addAttribute("allCourses", courseService.findAllCourses());
        return "enrollment/form";
    }

    @PostMapping("/add-enrollment")
    public String addEnrollment(@Valid @ModelAttribute Enrollment enrollment, BindingResult result, RedirectAttributes redirectAttributes,Model model){
        if (result.hasErrors()) {
            model.addAttribute("allStudents", studentService.findAllStudents());
            model.addAttribute("allCourses", courseService.findAllCourses());
            return "enrollment/form";
        }

        try {
            enrollmentService.saveEnrollment(enrollment);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            model.addAttribute("allStudents", studentService.findAllStudents());
            model.addAttribute("allCourses", courseService.findAllCourses());
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
        model.addAttribute("allStudents", studentService.findAllStudents());
        model.addAttribute("allCourses", courseService.findAllCourses());
        return "enrollment/enrollment-edit-form";
    }

    @PostMapping("/{id}/update-enrollment")
    public String updateEnrollment(@PathVariable String id, @Valid @ModelAttribute Enrollment updatedEnrollment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allStudents", studentService.findAllStudents());
            model.addAttribute("allCourses", courseService.findAllCourses());
            return "enrollment/enrollment-edit-form";
        }
        try {
            updatedEnrollment.setId(id);
            enrollmentService.updateEnrollment(updatedEnrollment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("allStudents", studentService.findAllStudents());
            model.addAttribute("allCourses", courseService.findAllCourses());
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