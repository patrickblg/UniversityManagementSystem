package com.example.UniversityManagementSystem.controller;
import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.service.DepartmentService;
import com.example.UniversityManagementSystem.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final UniversityService universityService;

    @Autowired
    public DepartmentController(DepartmentService departmentService, UniversityService universityService) {
        this.departmentService = departmentService;
        this.universityService = universityService;
    }

    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAllDepartments());
        return "department/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("allUniversities", universityService.findAllUniversities());
        return "department/form";
    }

    // Adaugă (Pregătit pentru @Valid)
    @PostMapping("/add-department")
    public String addDepartment(@Valid @ModelAttribute Department department, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "department/form";
        }
        try {
            departmentService.save(department);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "department/form";
        }
        return "redirect:/department";
    }

    // Afișează Detaliile (Nou)
    @GetMapping("/{id}/details")
    public String showDepartmentDetails(@PathVariable String id, Model model) {
        Department department = departmentService.findDepartmentById(id);
        if (department == null) return "redirect:/department";
        model.addAttribute("department", department);
        return "department/details"; // Partenerul va crea department/details.html
    }

    @GetMapping("/{id}/edit-department")
    public String showEditDepartmentForm(@PathVariable String id, Model model) {
        Department department = departmentService.findDepartmentById(id);
        if (department == null) return "redirect:/department";

        model.addAttribute("department", department);
        model.addAttribute("allUniversities", universityService.findAllUniversities());
        return "department/department-edit-form";
    }

    // Actualizează (Pregătit pentru @Valid)
    @PostMapping("/{id}/update-department")
    public String updateDepartment(@PathVariable String id, @Valid @ModelAttribute Department updatedDepartment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "department/department-edit-form";
        }
        try {
            updatedDepartment.setId(id);
            departmentService.updateDepartment(updatedDepartment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "department/department-edit-form";
        }
        return "redirect:/department";
    }

    // Șterge
    @PostMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department";
    }
}