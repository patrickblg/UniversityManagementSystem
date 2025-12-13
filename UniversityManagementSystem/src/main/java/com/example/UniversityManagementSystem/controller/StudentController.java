package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "sortField", defaultValue = "name")String sortField,
                              @RequestParam(value = "sortDir",defaultValue = "asc") String sortDir) {

        model.addAttribute("students",studentService.findAllStudents(name, sortField, sortDir));
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("name", name);
        return "student/index";
    }

    @GetMapping("/new-student")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "student/student-form";
    }

    @PostMapping("/add-student")
    public String addStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "student/student-form";
        }
        studentService.saveStudent(student);
        return "redirect:/student";
    }


    @GetMapping("/{id}/details")
    public String showStudentDetails(@PathVariable String id, Model model) {
        Student student = studentService.findStudent(id);
        if (student == null) return "redirect:/student";
        model.addAttribute("student", student);
        return "student/details";
    }

    @GetMapping("/{id}/edit-student")
    public String showEditStudentForm(@PathVariable String id, Model model) {
        Student student = studentService.findStudent(id);
        if (student == null) return "redirect:/student";
        model.addAttribute("student", student);
        return "student/student-edit-form";
    }

    @PostMapping("/{id}/update-student")
    public String updateStudent(@PathVariable String id, @Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student/student-edit-form";
        }
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