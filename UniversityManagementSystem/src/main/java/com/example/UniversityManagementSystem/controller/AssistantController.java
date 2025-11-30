package com.example.UniversityManagementSystem.controller;


import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.service.AssistantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assistant")
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }
    @GetMapping
    public String getAllAssistants(Model model) {
        model.addAttribute("assistants", assistantService.findAllAssistants());
        return "assistant/index";
    }

    @GetMapping("/new-assistant")
    public String showAddFrom(Model model) {
        model.addAttribute("assistant", new Assistant());
        return "assistant/form";
    }

    @PostMapping("/add-assistant")
    public String saveAssistant(@ModelAttribute Assistant assistant) {
        assistantService.saveAssistant(assistant);
        return "redirect:/assistant";
    }

    @GetMapping("/{id}/edit-assistant")
    public String showEditAssistantFrom(@PathVariable String id, Model model) {
        Assistant assistant = assistantService.findAssistantById(id);
        if (assistant == null) {return "redirect:/assistant";}
        model.addAttribute("assistant", assistant);
        return "assistant/assistant-edit-form";
    }

    @PostMapping("/{id}/update-assistant")
    public String updateAssistant(@PathVariable String id,@ModelAttribute Assistant assistant) {
        assistant.setId(id);
        assistantService.updateAssistant(assistant);
        return "redirect:/assistant";
    }

    @PostMapping("/{id}/delete-assistant")
    public String deleteAssistant(@PathVariable String id) {
        assistantService.deleteAssistant(id);
        return "redirect:/assistant";
    }



}
