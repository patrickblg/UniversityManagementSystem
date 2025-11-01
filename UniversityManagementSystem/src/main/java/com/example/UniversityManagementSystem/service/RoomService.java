package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Room;
import com.example.UniversityManagementSystem.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository assistantRepository) {
        this.roomRepository= roomRepository;
    }

    public Room saveRoom (Room r){
        return roomRepository.save(r);
    }

    public List<Room> findAllRooms(){
        return roomRepository.findAll();
    }

    public Room findRoomById(String id){
        return roomRepository.findById(id);
    }

    public void deleteRoom(String id){
        roomRepository.delete(id);
    }

}
