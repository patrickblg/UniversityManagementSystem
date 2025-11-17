    package com.example.UniversityManagementSystem.repository;
    import com.example.UniversityManagementSystem.model.Enrollment;
    import org.springframework.stereotype.Repository;

    @Repository
    public class EnrollmentRepository extends InFileRepo<Enrollment> {
        public EnrollmentRepository() {
            super("UniversityManagementSystem/src/main/resources/data/enrollment.json",Enrollment.class);
        }
    }
