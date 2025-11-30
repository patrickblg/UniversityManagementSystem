package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.University;
import com.example.UniversityManagementSystem.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public String getAllUniversity(Model model){
        model.addAttribute("universities",universityService.findAllUniversities());
        return "university/index";
    }

    @GetMapping("/new")
    public String showAddUniversityForm(Model model){
        model.addAttribute("university",new University());
        return "university/form";
    }

    // Adaugă (Pregătit pentru @Valid)
    @PostMapping("/add-university")
    public String addUniversity(@Valid @ModelAttribute University university, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "university/form";
        }
        // Logica de Business Validation (dacă aruncă excepție, va fi prinsă aici)
        try {
            universityService.saveUniversity(university);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "university/form";
        }
        return "redirect:/university";
    }

    // Afișează Detaliile (Nou)
    @GetMapping("/{id}/details")
    public String showUniversityDetails(@PathVariable String id, Model model) {
        University university = universityService.findUniversityById(id);
        if (university == null) return "redirect:/university";
        model.addAttribute("university", university);
        return "university/details"; // Partenerul va crea university/details.html
    }

    // Afișează formularul de editare
    @GetMapping("/{id}/edit-university")
    public String showEditUniversityForm(@PathVariable String id, Model model) {
        University university = universityService.findUniversityById(id);
        if (university == null) return "redirect:/university";
        model.addAttribute("university", university);
        return "university/university-edit-form";
    }

    // Actualizează (Pregătit pentru @Valid)
    @PostMapping("/{id}/update-university")
    public String updateUniversity(@PathVariable String id, @Valid @ModelAttribute University updatedUniversity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "university/university-edit-form";
        }
        try {
            updatedUniversity.setId(id);
            universityService.updateUniversity(updatedUniversity);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "university/university-edit-form";
        }
        return "redirect:/university";
    }

    // Șterge
    @PostMapping("/{id}/delete")
    public String deleteUniversity(@PathVariable String id){
        universityService.deleteUniversity(id);
        return "redirect:/university";
    }
}