package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.repository.AssistantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssistantService {

    private final AssistantRepository assistantRepository;

    public AssistantService(AssistantRepository assistantRepository) {
        this.assistantRepository= assistantRepository;
    }

    public Assistant saveAssistant(Assistant t){
        return assistantRepository.save(t);
    }

    public List<Assistant> findAllAssistants(){
        return assistantRepository.findAll();
    }

    public Assistant findAssistantById(String id){
        return assistantRepository.findById(id);
    }

    public void deleteAssistant(String id){
        assistantRepository.delete(id);
    }


}
