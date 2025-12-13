package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Assistant;
import com.example.UniversityManagementSystem.model.AssistantRole;
import com.example.UniversityManagementSystem.service.AssistantService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assistant")
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @GetMapping
    public String getAllAssistants(Model model,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "role", required = false) AssistantRole role,
                                   @RequestParam(value = "sortField", defaultValue = "name")String sortField,
                                   @RequestParam(value = "sortDir", defaultValue = "asc")String sortDir ) {
        model.addAttribute("assistants", assistantService.findAllAssistants(name,role,sortField, sortDir));
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("name", name);
        model.addAttribute("roleParam", role);
        model.addAttribute("allRoles", AssistantRole.values());

        return "assistant/index";
    }

    @GetMapping("/new")
    public String showAddFrom(Model model) {
        model.addAttribute("assistant", new Assistant());
        return "assistant/form";
    }

    @PostMapping("/add-assistant")
    public String saveAssistant(@Valid @ModelAttribute Assistant assistant, BindingResult result) {
        if (result.hasErrors()) {
            return "assistant/form";
        }
        assistantService.saveAssistant(assistant);
        return "redirect:/assistant";
    }

    @GetMapping("/{id}/details")
    public String showAssistantDetails(@PathVariable String id, Model model) {
        Assistant assistant = assistantService.findAssistantById(id);
        if (assistant == null) return "redirect:/assistant";
        model.addAttribute("assistant", assistant);
        return "assistant/details";
    }

    @GetMapping("/{id}/edit-assistant")
    public String showEditAssistantFrom(@PathVariable String id, Model model) {
        Assistant assistant = assistantService.findAssistantById(id);
        if (assistant == null) {return "redirect:/assistant";}
        model.addAttribute("assistant", assistant);
        return "assistant/assistant-edit-form";
    }

    @PostMapping("/{id}/update-assistant")
    public String updateAssistant(@PathVariable String id,@Valid @ModelAttribute Assistant assistant, BindingResult result) {
        if (result.hasErrors()) {
            return "assistant/assistant-edit-form";
        }
        assistant.setId(id);
        assistantService.updateAssistant(assistant);
        return "redirect:/assistant";
    }

    @PostMapping("/{id}/delete")
    public String deleteAssistant(@PathVariable String id) {
        assistantService.deleteAssistant(id);
        return "redirect:/assistant";
    }



}