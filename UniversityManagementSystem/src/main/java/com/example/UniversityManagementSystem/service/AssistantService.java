package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.repository.AssistantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssistantService {

    private final AssistantRepository assistantRepository;

    public AssistantService(AssistantRepository assistantRepository) {
        this.assistantRepository= assistantRepository;
    }

    public void saveAssistant(Assistant t){
        assistantRepository.save(t);
    }

    public List<Assistant> findAllAssistants(){
        return assistantRepository.findAll();
    }

    @Transactional
    public Assistant findAssistantById(String id){
        return assistantRepository.findById(id).orElse(null);
    }

    public void deleteAssistant(String id){
        assistantRepository.deleteById(id);
    }

    public void  updateAssistant(Assistant assistant){
        assistantRepository.save(assistant);
    }




}
