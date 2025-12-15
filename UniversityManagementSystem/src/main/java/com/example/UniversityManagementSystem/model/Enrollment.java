package com.example.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity

public class Enrollment implements Identifiable{
    @Id
    @NotBlank(message = "id must not be null")
    private String id;

    @ManyToOne
    @JoinColumn(name="student_id")
    @JsonBackReference
    @NotNull(message = "student must not be null")
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id")
    @JsonBackReference
    @NotNull(message = "course must not be null")
    private Course course;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "grade must not be null")
    private Grades grade;

    public Enrollment(String id, Grades grade, Student student, Course course) {
        this.id = id;
        this.grade = grade;
        this.student = student;
        this.course = course;
    }
    public Enrollment() {}
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    public Grades getGrade() {
        return grade;
    }
    public void setGrade(Grades grade) {
        this.grade = grade;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

}
