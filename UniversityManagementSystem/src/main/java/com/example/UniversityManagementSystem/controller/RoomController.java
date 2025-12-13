package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Room;
import com.example.UniversityManagementSystem.service.RoomService;
import com.example.UniversityManagementSystem.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final UniversityService universityService;

    @Autowired
    public RoomController(RoomService roomService,UniversityService universityService) {
        this.roomService = roomService;
        this.universityService = universityService;
    }

    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms());
        return "room/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("allUniversities", universityService.findAllUniversities());
        return "room/form";
    }

    // Adaugă (Pregătit pentru @Valid)
    @PostMapping("/add-room")
    public String addRoom(@Valid @ModelAttribute Room room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allUniversities", universityService.findAllUniversities());
            return "room/form";
        }
        try {
            roomService.saveRoom(room);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("allUniversities", universityService.findAllUniversities());
            return "room/form";
        }
        return "redirect:/room";
    }

    // Afișează Detaliile (Nou)
    @GetMapping("/{id}/details")
    public String showRoomDetails(@PathVariable String id, Model model) {
        Room room = roomService.findRoomById(id);
        if (room == null) return "redirect:/room";
        model.addAttribute("room", room);
        return "room/details"; // Partenerul va crea room/details.html
    }

    @GetMapping("/{id}/edit-room")
    public String showEditRoomForm(@PathVariable String id, Model model) {
        Room room = roomService.findRoomById(id);
        if (room == null) return "redirect:/room";

        model.addAttribute("room", room);
        model.addAttribute("allUniversities", universityService.findAllUniversities());
        return "room/room-edit-form";
    }

    // Actualizează (Pregătit pentru @Valid)
    @PostMapping("/{id}/update-room")
    public String updateRoom(@PathVariable String id, @Valid @ModelAttribute Room updatedRoom, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allUniversities", universityService.findAllUniversities());
            return "room/room-edit-form";
        }
        try {
            updatedRoom.setId(id);
            roomService.updateRoom(updatedRoom);
        } catch (IllegalArgumentException e) {
            model.addAttribute("allUniversities", universityService.findAllUniversities());
            model.addAttribute("errorMessage", e.getMessage());
            return "room/room-edit-form";
        }
        return "redirect:/room";
    }

    // Șterge
    @PostMapping("/{id}/delete")
    public String deleteRoom(@PathVariable String id) {
        roomService.deleteRoom(id);
        return "redirect:/room";
    }
}