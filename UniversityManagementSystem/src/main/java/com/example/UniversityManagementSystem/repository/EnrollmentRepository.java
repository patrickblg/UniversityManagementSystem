    package com.example.UniversityManagementSystem.repository;
    import com.example.UniversityManagementSystem.model.Enrollment;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.domain.Sort;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface EnrollmentRepository extends JpaRepository<Enrollment,String> {
        List<Enrollment> findByStudent_NameContainingIgnoreCase(String studentName, Sort sort);

        List<Enrollment> findByCourse_TitleContainingIgnoreCase(String courseTitle, Sort sort);

        List<Enrollment> findByStudent_NameContainingIgnoreCaseAndCourse_TitleContainingIgnoreCase(String studentName, String courseTitle, Sort sort);

    }
