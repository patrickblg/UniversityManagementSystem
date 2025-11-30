package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping
    public String getStudents(Model model) {

        model.addAttribute("students", studentService.findAllStudents());
        return "student/index";
    }

    @GetMapping("/new-student")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "student/student-form";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/student";
    }
    @GetMapping("/{id}/edit-student")
    public String showEditStudentForm(@PathVariable String id, Model model) {
        Student student = studentService.findStudent(id);
        if (student == null) return "redirect:/student";

        model.addAttribute("student", student);
        return "student/student-edit-form";
    }

    @PostMapping("/{id}/update-room")
    public String updateStudent(@PathVariable String id, @ModelAttribute Student student) {

        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable String id){
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }


}
