    package com.example.UniversityManagementSystem.controller;


    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/mainIndex")
    public class mainIndexC {

        @GetMapping
        public String showMainIndex(){
            return "mainFolder/mainIndex";
        }
    }
