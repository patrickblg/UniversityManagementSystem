package com.example.UniversityManagementSystem.controller;
import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAllDepartments());
        return "department/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("department", new Department("", ""));
        return "department/form";
    }

    @PostMapping
    public String addDepartment(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/departments";
    }
    @PostMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments";
    }

}
