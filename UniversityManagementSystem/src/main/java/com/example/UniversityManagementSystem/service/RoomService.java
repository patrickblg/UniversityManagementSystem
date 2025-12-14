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
    public List<Room> findAllRooms(String roomNumber, Double minCapacity, String roomName, String universityName, String sortField, String sortDirection){
        Sort sort;

        if("asc".equals(sortDirection)){
            sort=Sort.by(sortField).ascending();
        }else{
            sort=Sort.by(sortField).descending();
        }

        boolean filterByNumber = roomNumber != null && !roomNumber.isEmpty();
        boolean filterByMinCapacity = minCapacity != null;
        boolean filterByName = roomName != null && !roomName.isEmpty();
        boolean filterByUniversity = universityName != null && !universityName.isEmpty();

        //toate
        if (filterByNumber && filterByMinCapacity && filterByName && filterByUniversity) {
            return roomRepository.findByNumberContainingIgnoreCaseAndCapacityGreaterThanEqualAndNameContainingIgnoreCaseAndUniversity_NameContainingIgnoreCase(
                    roomNumber, minCapacity, roomName, universityName, sort);
        }
        //fara UniversityName
        else if (filterByNumber && filterByMinCapacity && filterByName) {
            return roomRepository.findByNumberContainingIgnoreCaseAndCapacityGreaterThanEqualAndNameContainingIgnoreCase(
                    roomNumber, minCapacity, roomName, sort);
        }
        //fara RoomName
        else if (filterByNumber && filterByMinCapacity && filterByUniversity) {
            return roomRepository.findByNumberContainingIgnoreCaseAndCapacityGreaterThanEqualAndUniversity_NameContainingIgnoreCase(
                    roomNumber, minCapacity, universityName, sort);
        }
        //fara RoomNumber
        else if (filterByMinCapacity && filterByName && filterByUniversity) {
            return roomRepository.findByCapacityGreaterThanEqualAndNameContainingIgnoreCaseAndUniversity_NameContainingIgnoreCase(
                    minCapacity, roomName, universityName, sort);
        }
        //nume univ + capacitate
        else if (filterByUniversity && filterByMinCapacity) {
            return roomRepository.findByCapacityGreaterThanEqualAndUniversity_NameContainingIgnoreCase(minCapacity, universityName, sort);
        }
        //RoomName
        else if (filterByName) {
            return roomRepository.findByNameContainingIgnoreCase(roomName, sort);
        }
        //RoomNumber
        else if (filterByNumber) {
            return roomRepository.findByNumberContainingIgnoreCase(roomNumber, sort);
        }
        //capacitate minima
        else if (filterByMinCapacity) {
            return roomRepository.findByCapacityGreaterThanEqual(minCapacity, sort);
        }
        //UniversityName
        else if (filterByUniversity) {
            return roomRepository.findByUniversity_NameContainingIgnoreCase(universityName, sort);
        }
        //doar sortare
        else {
            return roomRepository.findAll(sort);
        }

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
