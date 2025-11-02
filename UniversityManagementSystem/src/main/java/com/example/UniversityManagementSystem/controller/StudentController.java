package com.example.UniversityManagementSystem.controller;


import com.example.UniversityManagementSystem.model.Enrollment;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.service.EnrollmentService;
import com.example.UniversityManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//student+enrollment
@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    @Autowired
    public StudentController(StudentService studentService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public String getStudentsAndEnrollments(Model model){
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("enrollments", enrollmentService.getAllEnrollments());
        return "students/index";
    }

    @GetMapping("/new-student")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "students/students-form";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/new-enrollmemt")
    public String showEnrollmentForm(Model model){
        model.addAttribute("enrollment", new Enrollment());
        return "students/enrollment-form";
    }

    @PostMapping("/add-enrollment")
    public String addEnrollment(@ModelAttribute Enrollment enrollment){
        enrollmentService.saveEnrollment(enrollment);
        return "redirect:/student";
    }

    @PostMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable String id){
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }

    @PostMapping
    public String deleteEnrollment(@PathVariable String id){
        enrollmentService.deleteEnrollmentById(id);
        return "redirect:/student";

    }


}
