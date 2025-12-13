package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.model.AssistantRole;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.AssistantRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
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

    public List<Assistant> findAllAssistants(String name, AssistantRole role, String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }
        if(name!=null&&!name.isEmpty()&&role!=null){
            return assistantRepository.findByNameContainingIgnoreCaseAndRole(name,role,sort);
        }else if(name!=null&&!name.isEmpty()){
            return assistantRepository.findByNameContainingIgnoreCase(name,sort);
        }else if(role!=null){
            return assistantRepository.findByRole(role,sort);
        }else{
            return assistantRepository.findAll(sort);
        }
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
