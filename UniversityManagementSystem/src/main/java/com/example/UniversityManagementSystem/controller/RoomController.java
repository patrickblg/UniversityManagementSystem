package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Room;
import com.example.UniversityManagementSystem.model.University;
import com.example.UniversityManagementSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms());
        return "room/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("room", new Room());
        return "room/form";
    }

    @PostMapping("/add-room")
    public String addRoom(@ModelAttribute Room room) {
        roomService.saveRoom(room);
        return "redirect:/room";
    }
    @GetMapping("/{id}/edit-room")
    public String showEditRoomForm(@PathVariable String id, Model model) {
        Room room = roomService.findRoomById(id);
        if (room == null) return "redirect:/room";

        model.addAttribute("room", room);
        return "room/room-edit-form";
    }

    @PostMapping("/{id}/update-room")
    public String updateRoom(@PathVariable String id, @ModelAttribute Room updatedRoom) {

        updatedRoom.setId(id);
        roomService.updateRoom(updatedRoom);
        return "redirect:/room";
    }
    @PostMapping("/{id}/delete")
    public String deleteRoom(@PathVariable String id) {
        roomService.deleteRoom(id);
        return "redirect:/room";
    }
}
