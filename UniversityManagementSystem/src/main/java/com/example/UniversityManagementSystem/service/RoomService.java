package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Room;
import com.example.UniversityManagementSystem.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository= roomRepository;
    }

    public void saveRoom (Room r){
        roomRepository.save(r);
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

    public void updateRoom(Room r){
        roomRepository.update(r);
    }

    //public Room save(Room r){
    //   return roomRepository.save(r);
    //}


}
