package com.example.UniversityManagementSystem.repository;
import com.example.UniversityManagementSystem.model.ManagingRole;
import com.example.UniversityManagementSystem.model.TeachingAssignment;
import com.example.UniversityManagementSystem.model.University;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeachingAssignmentRepository extends JpaRepository<TeachingAssignment,String> {
    List<TeachingAssignment> findByManaging(ManagingRole managingRole, Sort sort);
}