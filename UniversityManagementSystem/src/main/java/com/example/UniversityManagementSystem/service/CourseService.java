package com.example.UniversityManagementSystem.service;
import com.example.UniversityManagementSystem.model.Course;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final RoomRepository roomRepository;

    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository, RoomRepository roomRepository) {
        this.courseRepository= courseRepository;
        this.departmentRepository = departmentRepository;
        this.roomRepository = roomRepository;

    }
    public void saveCourse(Course c ){
        if (c.getDepartment() == null || c.getDepartment().getId() == null || !departmentRepository.existsById(c.getDepartment().getId())) {
            throw new IllegalArgumentException("Nu se poate salva cursul: Departamentul asociat nu există.");
        }

        if (c.getRoom() == null || c.getRoom().getId() == null || !roomRepository.existsById(c.getRoom().getId())) {
            throw new IllegalArgumentException("Nu se poate salva cursul: Sala asociată nu există.");
        }
        courseRepository.save(c);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }
    public List<Course> findAllCourses(String title, Double maxCredits, String departmentName, String roomName, String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }
        boolean filterByTitle = title != null && !title.isEmpty();
        boolean filterByCredits = maxCredits != null;
        boolean filterByDepartment = departmentName != null && !departmentName.isEmpty();
        boolean filterByRoom = roomName != null && !roomName.isEmpty();

        if (filterByTitle && filterByDepartment && filterByCredits) {
        }
        if (filterByTitle && filterByCredits) {
            // Notă: Metoda din Repository folosește 'name' pentru titlu și 'Integer' pentru credite. Presupunem că 'name' se referă la 'title'
            return courseRepository.findByTitleContainingIgnoreCaseAndCreditsLessThanEqual(title, maxCredits.intValue(), sort);
        }
        // Departament ȘI Credite Max
        else if (filterByDepartment && filterByCredits) {
            // Notă: Metoda din Repository folosește 'double' pentru credite, dar creditul este stocat ca 'Integer' sau 'double'. Folosim valoarea 'Double'.
            return courseRepository.findByDepartment_NameContainingIgnoreCaseAndCreditsLessThanEqual(departmentName, maxCredits, sort);
        }
        // Titlu ȘI Departament
        else if (filterByTitle && filterByDepartment) {
            return courseRepository.findByTitleContainingIgnoreCaseAndDepartment_NameContainingIgnoreCase(title, departmentName, sort);
        }
        // Titlu ȘI Sală
        else if (filterByTitle && filterByRoom) {
            return courseRepository.findByTitleContainingIgnoreCaseAndRoom_NameContainingIgnoreCase(title, roomName, sort);
        }

        else if (filterByTitle) {
            return courseRepository.findByTitleContainingIgnoreCase(title, sort);
        }
        else if (filterByCredits) {
            return courseRepository.findByCreditsLessThanEqual(maxCredits.intValue(), sort);
        }
        else if (filterByDepartment) {
            return courseRepository.findByDepartment_NameContainingIgnoreCase(departmentName, sort);
        }
        else if (filterByRoom) {
            return courseRepository.findByRoom_NameContainingIgnoreCase(roomName, sort);
        }
        else {
            return courseRepository.findAll(sort);
        }
    }

    public Course findCourseById(String id){
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(String courseId){

        courseRepository.deleteById(courseId);
    }

    public void updateCourse(Course c){
        if (c.getDepartment() == null || c.getDepartment().getId() == null || !departmentRepository.existsById(c.getDepartment().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza cursul: Departamentul asociat nu există.");
        }
        if (c.getRoom() == null || c.getRoom().getId() == null || !roomRepository.existsById(c.getRoom().getId())) {
            throw new IllegalArgumentException("Nu se poate actualiza cursul: Sala asociată nu există.");
        }
        courseRepository.save(c);
    }
}





