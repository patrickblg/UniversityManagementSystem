package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant,String> {


}