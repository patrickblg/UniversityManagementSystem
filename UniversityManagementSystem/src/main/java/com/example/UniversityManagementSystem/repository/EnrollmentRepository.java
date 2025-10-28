package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.Enrollment;

import java.util.List;
import java.util.ArrayList;

public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();
    public Enrollment save(Enrollment e) {
        enrollments.add(e);
        return e;
    }

    public Enrollment findById(String id) {
        for (Enrollment e : enrollments) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void delete(Enrollment e) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getId().equals(e.getId())) {
                enrollments.remove(i);
                i--;
            }
        }
    }
}
