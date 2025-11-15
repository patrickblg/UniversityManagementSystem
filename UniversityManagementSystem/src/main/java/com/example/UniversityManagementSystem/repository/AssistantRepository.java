package com.example.UniversityManagementSystem.repository;

import com.example.UniversityManagementSystem.model.Assistant;
import org.springframework.stereotype.Repository;

@Repository
public class AssistantRepository extends InFileRepo<Assistant> {

    public AssistantRepository() {
        super("UniversityManagementSystem/src/main/resources/data/assistant.json",Assistant.class);
    }
}