package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.University;
import com.example.UniversityManagementSystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    //afiseaza toate universitatiile
    @GetMapping
    public String getAllUniversity(Model model){
        model.addAttribute("universities",universityService.findAllUniversities());
        return "university/index";
    }

    //afiseaza un formular pentru a adauga o noua universitate
    @GetMapping("/new")
    public String showAddUniversityForm(Model model){
        model.addAttribute("university",new University());
        return "university/form";
    }

    //adauga o universitate noua si te redirectioneza inapoi pe pagina principala
    @PostMapping
    public String addUniversity(@ModelAttribute University university){
        universityService.saveUniversity(university);
        return "redirect:/university";
    }

    //sterge o universitate si te redirectioneaza
    @PostMapping("/{id}/delete")
    public String deleteUniversity(@PathVariable String id){
        universityService.deleteUniversity(id);
        return "redirect:/university";
    }





}
