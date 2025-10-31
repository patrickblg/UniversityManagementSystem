package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Enrollment;

import java.util.List;
import java.util.ArrayList;

public class EnrollmentRepository implements BaseRepo<Enrollment> {
    private final List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public Enrollment save(Enrollment e) {
        enrollments.add(e);
        return e;
    }
    @Override
    public Enrollment findById(String id) {
        for (Enrollment e : enrollments) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
    @Override
    public List<Enrollment> findAll() {
        return enrollments;
    }
    @Override
    public void delete(String id) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getId().equals(id)) {
                enrollments.remove(i);
                i--;
            }
        }
    }
}
