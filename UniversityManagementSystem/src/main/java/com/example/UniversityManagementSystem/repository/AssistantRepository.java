package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.model.AssistantRole;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant,String> {
    List<Assistant> findByNameContainingIgnoreCase(String name,Sort sort);
    List<Assistant> findByRole(AssistantRole role,Sort sort);
    List<Assistant> findByNameContainingIgnoreCaseAndRole(String name,AssistantRole role, Sort sort);


}