    package com.example.UniversityManagementSystem.model;

    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;
    public class Room  implements Identifiable{
        private String id;
        private double capacity;
        private String number;
        private String name;
        List<Course> courses;


        public Room(String id, double capacity, String number, String name) {
            this.id = id;
            this.capacity = capacity;
            this.number = number;
            this.name = name;
            this.courses = new ArrayList<>();
        }
        public Room() {}
        @Override
        public String getId() {
            return id;
        }
        @Override
        public void setId(String id) {
            this.id= id;
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
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
