package com.example.UniversityManagementSystem.service;

import com.example.UniversityManagementSystem.model.Room;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.RoomRepository;
import com.example.UniversityManagementSystem.repository.UniversityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final UniversityRepository universityRepository;

    public RoomService(RoomRepository roomRepository, UniversityRepository universityRepository) {
        this.roomRepository= roomRepository;
        this.universityRepository = universityRepository;
    }

    public void saveRoom (Room r){
        if (r.getUniversity() == null || r.getUniversity().getId() == null || !universityRepository.existsById(r.getUniversity().getId())) {
            throw new IllegalArgumentException("Nu se poate salva sala: Universitatea asociată nu există.");
        }
        roomRepository.save(r);
    }

    public List<Room> findAllRooms(){
        return roomRepository.findAll();
    }
    public List<Room> findAllRooms(String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }

        return  roomRepository.findAll(sort);
    }

    public Room findRoomById(String id){
        return roomRepository.findById(id).orElse(null);
    }

    public void deleteRoom(String id){
        roomRepository.deleteById(id);
    }

    public void updateRoom(Room r){
        if (r.getUniversity() == null || r.getUniversity().getId() == null || !universityRepository.existsById(r.getUniversity().getId())) {
            throw new IllegalArgumentException("Nu se poate salva sala: Universitatea asociată nu există.");
        }
        roomRepository.save(r);
    }



}
