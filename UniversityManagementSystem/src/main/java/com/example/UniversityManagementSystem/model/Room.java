package com.example.UniversityManagementSystem.model;

import java.util.ArrayList;
import java.util.List;
public class Room {
    private String roomId;
    private double capacity;
    private String number;
    List<Course> courses;
    public Room(String roomId, double capacity, String number) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.number = number;
        this.courses = new ArrayList<>();
    }
    public Room() {}
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
