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
    public String getStudentsAndEnrollments(Model model) {

        enrollmentService.getEnrollmentCountsPerStudent(studentService.findAllStudents());

        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("enrollments", enrollmentService.getAllEnrollments());

        return "student/index";
    }

    @GetMapping("/new-student")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "student/student-form";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student){
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

    @PostMapping("/{id}/update-student")
    public String updateStudent(@PathVariable String id, @ModelAttribute Student updatedStudent) {

        updatedStudent.setId(id);
        studentService.updateStudent(updatedStudent);
        return "redirect:/student";
    }

    @GetMapping("/new-enrollment")
    public String showEnrollmentForm(Model model){
        model.addAttribute("enrollment", new Enrollment());
        return "student/enrollment-form";
    }

    @PostMapping("/add-enrollment")
    public String addEnrollment(@ModelAttribute Enrollment enrollment){
        try {
            enrollmentService.saveEnrollment(enrollment);
        }catch (IllegalArgumentException e){
            return  "redirect:/student";
        }
        return "redirect:/student";
    }
    @GetMapping("/enrollment/{id}/edit-enrollment")
    public String showEditEnrollmentForm(@PathVariable String id, Model model) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment == null) return "redirect:/student";

        model.addAttribute("enrollemnt", enrollment);
        return "student/enrollment-edit-form";
    }

    @PostMapping("/enrollment/{id}/update-enrollment")
    public String updateEnrollment(@PathVariable String id, @ModelAttribute Enrollment updatedEnrollment) {

        updatedEnrollment.setId(id);
        enrollmentService.updateEnrollment(updatedEnrollment);
        return "redirect:/student";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable String id){
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }

    @PostMapping("/enrollment/{id}/delete")
    public String deleteEnrollment(@PathVariable String id){
        enrollmentService.deleteEnrollmentById(id);
        return "redirect:/student";

    }


}
