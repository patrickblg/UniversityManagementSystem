package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.service.AssistantService;
import com.example.UniversityManagementSystem.service.CourseService;
import com.example.UniversityManagementSystem.service.TeacherService;
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
    private final CourseService courseService;
    private final TeacherService teacherService;
    private final AssistantService assistantService;

    public TeachingAssignmentController(TeachingAssignmentService teachingAssignmentService, CourseService courseService, TeacherService teacherService, AssistantService assistantService) {
        this.teachingAssignmentService = teachingAssignmentService;
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.assistantService = assistantService;
    }

    @GetMapping
    public String showAllTeachingAssignments(Model model,
                                             @RequestParam(value = "sortField",defaultValue = "id")String sortField,
                                             @RequestParam(value = "sortDir",defaultValue = "asc")String sortDir) {
        model.addAttribute("teachingassignments",teachingAssignmentService.findAllTeachingAssignments(sortField, sortDir));
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        return "teachingassignment/index";
    }

    @GetMapping("/new")
    public String showTeachingAssignmentForm(Model model) {
        model.addAttribute("teachingAssignment",new TeachingAssignment());
        model.addAttribute("allCourses", courseService.findAllCourses());
        model.addAttribute("allTeachers", teacherService.findAll());
        model.addAttribute("allAssistants", assistantService.findAllAssistants());
        return "teachingassignment/form";
    }

    @PostMapping("/add-teachingassignment")
    public String addTeachingAssignment(@Valid @ModelAttribute TeachingAssignment teachingAssignment, BindingResult result, RedirectAttributes redirectAttributes,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allCourses", courseService.findAllCourses());
            model.addAttribute("allTeachers", teacherService.findAll());
            model.addAttribute("allAssistants", assistantService.findAllAssistants());
            return "teachingassignment/form";
        }
        try {
            teachingAssignmentService.saveTeachingAssignment(teachingAssignment);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            model.addAttribute("allCourses", courseService.findAllCourses());
            model.addAttribute("allTeachers", teacherService.findAll());
            model.addAttribute("allAssistants", assistantService.findAllAssistants());
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

        model.addAttribute("teachingAssignment", teachingassignment);
        model.addAttribute("allCourses", courseService.findAllCourses());
        model.addAttribute("allTeachers", teacherService.findAll());
        model.addAttribute("allAssistants", assistantService.findAllAssistants());
        return "teachingassignment/ta-edit-form";
    }

    @PostMapping("/{id}/update-teachingassignment")
    public String updateTeachingAssignment(@PathVariable String id,
                                           @Valid @ModelAttribute TeachingAssignment teachingAssignment,
                                           BindingResult result,
                                           Model model) {

        // --- HELPER TO RELOAD DATA IF ERROR OCCURS ---
        if (result.hasErrors()) {
            // 1. Reload the original data to get the missing Course and Staff
            TeachingAssignment original = teachingAssignmentService.findTeachingAssignmentById(id);
            if (original != null) {
                teachingAssignment.setCourse(original.getCourse());
                teachingAssignment.setStaff(original.getStaff());
            }

            // 2. Add attributes and return form
            model.addAttribute("allCourses", courseService.findAllCourses());
            model.addAttribute("allTeachers", teacherService.findAll());
            model.addAttribute("allAssistants", assistantService.findAllAssistants());
            return "teachingassignment/ta-edit-form";
        }

        try {
            teachingAssignment.setId(id);
            teachingAssignmentService.updateTeachingAssignment(teachingAssignment);
        } catch (IllegalArgumentException e) {
            // --- REPEAT RELOAD LOGIC FOR EXCEPTION BLOCK ---
            TeachingAssignment original = teachingAssignmentService.findTeachingAssignmentById(id);
            if (original != null) {
                teachingAssignment.setCourse(original.getCourse());
                teachingAssignment.setStaff(original.getStaff());
            }

            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("allCourses", courseService.findAllCourses());
            model.addAttribute("allTeachers", teacherService.findAll());
            model.addAttribute("allAssistants", assistantService.findAllAssistants());
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