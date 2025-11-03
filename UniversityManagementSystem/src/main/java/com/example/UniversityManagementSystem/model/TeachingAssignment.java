package com.example.UniversityManagementSystem.model;

public class TeachingAssignment {
    private String id;
    private String courseId;
    private String staffId;
    private String managing;

    public TeachingAssignment(String id, String courseId, String staffId, String managing) {
        this.id = id;
        this.courseId = courseId;
        this.staffId = staffId;
        this.managing = managing;
    }
    public TeachingAssignment() {}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public String getManaging() {
        return managing;
    }
    public void setManaging(String managing) {
        this.managing = managing;
    }

}
